package trivago.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import trivago.enums.DriverType;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;

import static io.appium.java_client.service.local.flags.GeneralServerFlag.LOG_LEVEL;

@Slf4j
@Data
public class DriverFactory {
    private WebDriver webDriver;
    private AndroidDriver androidDriver;
    private AppiumDriverLocalService service;


    public DriverFactory(@NotNull DriverType driverType) {
        switch (driverType) {
            case CHROME -> createChromeDriver();
            case FIREFOX -> createFirefoxDriver();
            case ANDROID -> createAndroidDriver();
            case EDGE -> createEdgeDriver();
            case SAFARI -> createSafariDriver();
        }
    }

    private void createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.silentOutput", "true");
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("silent",
                "window-size=1920,1080",
                "ignore-certificate-errors",
                "--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
    }

    private void createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
    }

    private void createEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        new EdgeDriver();
    }

    private void createSafariDriver() {
        WebDriverManager.safaridriver().setup();
        new SafariDriver();
    }

    private void createAndroidDriver(){
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withTimeout(Duration.ofSeconds(60))
                .withArgument(LOG_LEVEL, "error");

        this.service = AppiumDriverLocalService.buildService(serviceBuilder);
        this.service.start();
        File file;
        File app;
        Properties properties;
        try {
            file = new File(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("android.local.properties")).toURI());
            properties = new Properties();
            properties.load(new FileInputStream(file));
            app = new File(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource(properties.getProperty("app"))).toURI());
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName(properties.getProperty("deviceName"))
                .setApp(app.getAbsolutePath())
                .eventTimings();
        properties.remove("deviceName");
        properties.remove("app");
        properties.forEach((key, value) -> options.setCapability(key.toString(), value.toString()));
        androidDriver = new AndroidDriver(service.getUrl(), options);
    }
}

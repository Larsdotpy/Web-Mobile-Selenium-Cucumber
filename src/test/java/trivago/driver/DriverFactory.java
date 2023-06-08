package trivago.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import trivago.enums.DriverType;

import java.time.Duration;
import java.util.logging.Level;

import static trivago.config.Constants.MAX_IMPLICIT_WAIT;

@Slf4j
@Data
public class DriverFactory {
    private DriverType driverType;
    private WebDriver driver;

    public DriverFactory(@NotNull DriverType driverType) {
        this.driverType = driverType;
        switch (driverType) {
            case CHROME -> createChromeDriver();
            case FIREFOX -> createFirefoxDriver();
            case EDGE -> createEdgeDriver();
            case SAFARI -> createSafariDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(MAX_IMPLICIT_WAIT));
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
        driver = new ChromeDriver(options);
    }

    private void createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    private void createEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        new EdgeDriver();
    }

    private void createSafariDriver() {
        WebDriverManager.safaridriver().setup();
        new SafariDriver();
    }

    private void quitDriver() {
        driver.quit();
    }
}

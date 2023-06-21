package trivago.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import trivago.context.ScenarioContext;
import trivago.driver.DriverFactory;
import trivago.enums.DriverType;
import trivago.pages.Mobile.*;
import trivago.pages.Web.HomePage;
import java.util.Objects;

public class Hooks extends CucumberScenario {
    private final ScenarioContext scenarioContext;

    public Hooks (ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Before
    public void baseInit(Scenario scenario) {
        CucumberScenario.scenario = scenario;
    }

    @Before(value = "@Web")
    public void initWeb() {
        DriverType driverType = DriverType.CHROME;
        if (!Objects.isNull(System.getProperty("browser")))
        {
            driverType = DriverType.valueOf(System.getProperty("browser").toUpperCase());
        }
        DriverFactory driverFactory = new DriverFactory(driverType);
        scenarioContext.setWebDriver(driverFactory.getWebDriver());
        scenarioContext.setHomePage(new HomePage(scenarioContext.getWebDriver()));
    }

    @Before(value = "@Mobile")
    public void initApp() {
        DriverType driverType = DriverType.ANDROID;
        if (!Objects.isNull(System.getProperty("browser")))
        {
            driverType = DriverType.valueOf(System.getProperty("browser").toUpperCase());
        }
        DriverFactory driverFactory = new DriverFactory(driverType);
        scenarioContext.setAppiumDriver(driverFactory.getAndroidDriver());
        scenarioContext.setService(driverFactory.getService());
        scenarioContext.setMobileOnboardingPage(new MobileOnboardingPage(scenarioContext.getAppiumDriver()));
        scenarioContext.setMobileHomePage(new MobileHomePage(scenarioContext.getAppiumDriver()));
        scenarioContext.setMobileSettingsPage(new MobileSettingsPage(scenarioContext.getAppiumDriver()));
        scenarioContext.setMobileBrowserPage(new MobileBrowserPage(scenarioContext.getAppiumDriver()));
        scenarioContext.setMobileSearchPage(new MobileSearchPage(scenarioContext.getAppiumDriver()));
    }

    @After(value = "@Web")
    public void tearDownWeb() {
        scenarioContext.getWebDriver().quit();
    }

    @After(value = "@Mobile")
    public void tearDownApp() {
        scenarioContext.getAppiumDriver().quit();
        scenarioContext.getService().stop();
    }
}

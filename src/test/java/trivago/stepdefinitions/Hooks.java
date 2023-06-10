package trivago.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import trivago.context.ScenarioContext;
import trivago.driver.DriverFactory;
import trivago.enums.DriverType;
import trivago.pages.HomePage;
import trivago.pages.HotelSearchPage;
import trivago.pages.LoginPage;

public class Hooks extends CucumberScenario {
    private final ScenarioContext scenarioContext;

    public Hooks (ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Before
    public void init(Scenario scenario) {
        CucumberScenario.scenario = scenario;
        scenarioContext.setDriver(new DriverFactory(DriverType.CHROME).getDriver());
        scenarioContext.setHomePage(new HomePage(scenarioContext.getDriver()));
        scenarioContext.setLoginPage(new LoginPage(scenarioContext.getDriver()));
        scenarioContext.setHotelSearchPage(new HotelSearchPage(scenarioContext.getDriver()));
    }

    @After
    public void tearDownApp() {
        scenarioContext.getDriver().quit();
    }
}

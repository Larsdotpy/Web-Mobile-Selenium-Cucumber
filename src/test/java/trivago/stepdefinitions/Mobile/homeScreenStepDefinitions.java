package trivago.stepdefinitions.Mobile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import trivago.context.ScenarioContext;
import trivago.stepdefinitions.CucumberScenario;

public class homeScreenStepDefinitions extends CucumberScenario {

    private final ScenarioContext scenarioContext;

    public homeScreenStepDefinitions(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @And("I am on the homescreen")
    public void iAmOnTheHomescreen() {
        scenarioContext.getMobileHomePage().homescreenLogoIsDisplayed();
    }

    @Then("I click on settings")
    public void iClickOnSettings() {
        scenarioContext.getMobileHomePage().clickOnSettings();
    }
}

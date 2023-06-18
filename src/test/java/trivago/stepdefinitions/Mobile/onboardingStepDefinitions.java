package trivago.stepdefinitions.Mobile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import trivago.context.ScenarioContext;
import trivago.stepdefinitions.CucumberScenario;

public class onboardingStepDefinitions extends CucumberScenario {

    private final ScenarioContext scenarioContext;

    public onboardingStepDefinitions(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Given("I start the Trivago app with english language settings")
    public void iStartTheTrivagoAppWithEnglishLanguageSettings() {
        scenarioContext.getMobileOnboardingPage().clickConfirm();
    }

    @Then("I accept the cookies")
    public void iAcceptTheCookies() {
        scenarioContext.getMobileOnboardingPage().acceptCookies();
    }


    @And("I skip price alerts notifications")
    public void iSkipPriceAlertsNotifications() {
        scenarioContext.getMobileOnboardingPage().skipPriceAlertsNotification();
    }
}

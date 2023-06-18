package trivago.stepdefinitions.Mobile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import trivago.context.ScenarioContext;
import trivago.stepdefinitions.CucumberScenario;

public class chromeBrowserStepDefinitions extends CucumberScenario {

    private final ScenarioContext scenarioContext;

    public chromeBrowserStepDefinitions(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Then("I press accept and continue in Chrome")
    public void iPressAcceptAndContinueInChrome() {
        scenarioContext.getMobileChromeBrowserPage().acceptAndContinue();
    }

    @And("I decline the option to turn on sync")
    public void iDeclineTheOptionToTurnOnSync() {
        scenarioContext.getMobileChromeBrowserPage().declineTurnOnSync();
    }

    @Then("I use an invalid email and password")
    public void iUseAnInvalidEmailAndPassword() {
        scenarioContext.getMobileChromeBrowserPage().inputInvalidEmail();
        scenarioContext.getMobileChromeBrowserPage().inputInvalidPassword();
    }

    @And("I attempt to login")
    public void iAttemptToLogin() {
        scenarioContext.getMobileChromeBrowserPage().pressLoginBtn();
    }

    /*
    @Then("An error message is displayed")
    public void anErrorMessageIsDisplayed() {
    }

    CHECK CORRESPONDING FEATURE FILE FOR REASON TO OMIT THIS STEP FOR NOW!

     */
}

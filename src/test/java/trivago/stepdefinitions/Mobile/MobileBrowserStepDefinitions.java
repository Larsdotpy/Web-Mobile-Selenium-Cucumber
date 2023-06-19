package trivago.stepdefinitions.Mobile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import trivago.context.ScenarioContext;
import trivago.stepdefinitions.CucumberScenario;

public class MobileBrowserStepDefinitions extends CucumberScenario {

    private final ScenarioContext scenarioContext;

    public MobileBrowserStepDefinitions(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Then("I use a valid email")
    public void iUseAValidEmailAndPassword() {
        scenarioContext.getMobileBrowserPage().inputValidEmail();
    }

    @And("I click NEXT")
    public void iClickNEXT() {
        scenarioContext.getMobileBrowserPage().pressNext();
    }

    @And("I use a valid password")
    public void iUseAValidPassword() {
        scenarioContext.getMobileBrowserPage().inputValidPassword();
    }

    @And("I attempt to login")
    public void iAttemptToLogin() {
        scenarioContext.getMobileBrowserPage().pressLoginBtn();
    }


    @Then("I am successfully logged in")
    public void iAmSuccessfullyLoggedIn() throws InterruptedException {
        scenarioContext.getMobileBrowserPage().checkSuccessfullyLoggedIn();
    }
}

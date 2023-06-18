package trivago.stepdefinitions.Mobile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import trivago.context.ScenarioContext;
import trivago.stepdefinitions.CucumberScenario;

public class settingsStepDefinitions extends CucumberScenario {

    private final ScenarioContext scenarioContext;

    public settingsStepDefinitions(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @And("I press the login button")
    public void iPressTheLoginButton() {
        scenarioContext.getMobileSettingsPage().goToLoginScreen();
    }
}

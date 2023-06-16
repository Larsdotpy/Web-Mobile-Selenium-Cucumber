package trivago.stepdefinitions.Mobile;

import io.cucumber.java.en.Given;
import trivago.context.ScenarioContext;
import trivago.stepdefinitions.CucumberScenario;

public class homescreenStepDefinitions extends CucumberScenario {

    private final ScenarioContext scenarioContext;

    public homescreenStepDefinitions(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }
    @Given("I start the Trivago app")
    public void iStartTheTrivagoApp() {
        scenarioContext.getMobileHomePage().clickConfirm();
    }
}

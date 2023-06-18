package trivago.stepdefinitions.Web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import trivago.context.ScenarioContext;
import trivago.pages.Web.LoginPage;
import trivago.stepdefinitions.CucumberScenario;

public class LoginPageStepDefinitions extends CucumberScenario {


    private final LoginPage loginPage;
    private final ScenarioContext scenarioContext;

    public LoginPageStepDefinitions( ScenarioContext scenarioContext) {
        this.loginPage = scenarioContext.getLoginPage();
        this.scenarioContext = scenarioContext;
    }

    @When("User enters an invalid email")
    public void userEntersAnInvalidEmail() {
        loginPage.enterInvalidEmail();
    }

    @Then("A notification is shown displaying {string} and has {string} hex color value")
    public void aNotificationIsShownDisplayingAndHasHexColorValue(String errorMsg, String hexColor) {
        loginPage.errorNotificiationIsDisplayed();
        loginPage.errorNotificationIsOfdb3734HexValue();
    }
}

package trivago.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import trivago.context.ScenarioContext;
import trivago.pages.LoginPage;

public class LoginPageStepDefinitions {


    private final LoginPage loginPage;
    private final ScenarioContext scenarioContext;

    public LoginPageStepDefinitions(LoginPage loginPage, ScenarioContext scenarioContext) {
        this.loginPage = loginPage;
        this.scenarioContext = scenarioContext;
    }

    @When("User enters an invalid email")
    public void userEntersAnInvalidEmail() {
        scenarioContext.getLoginPage().enterInvalidEmail();
    }

    @Then("A notification is shown displaying {string} and has {string} hex color value")
    public void aNotificationIsShownDisplayingAndHasHexColorValue(String errorMsg, String hexColor) {
        scenarioContext.getLoginPage().errorNotificiationIsDisplayed();
        scenarioContext.getLoginPage().errorNotificationIsOfdb3734HexValue();
    }
}

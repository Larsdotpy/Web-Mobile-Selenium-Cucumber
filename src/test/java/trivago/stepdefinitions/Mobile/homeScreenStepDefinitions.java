package trivago.stepdefinitions.Mobile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import trivago.context.ScenarioContext;
import trivago.stepdefinitions.CucumberScenario;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    @And("I press the search button without filling out details")
    public void iPressTheSearchButtonWithoutFillingOutDetails() {
        scenarioContext.getMobileHomePage().clickOnSearchHotelBtn();
    }

    @And("I select favorites")
    public void iSelectFavorites() {
        scenarioContext.getMobileHomePage().clickOnFavoriteBtn();
    }

    @Then("The hotel is successfully added")
    public void theHotelIsSuccessfullyAdded() {
        //code
    }
}

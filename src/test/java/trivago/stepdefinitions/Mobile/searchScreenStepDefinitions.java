package trivago.stepdefinitions.Mobile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import trivago.context.ScenarioContext;
import trivago.stepdefinitions.CucumberScenario;

public class searchScreenStepDefinitions extends CucumberScenario {

    private final ScenarioContext scenarioContext;

    public searchScreenStepDefinitions(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @And("I press on the maps button")
    public void iPressOnTheMapsButton() {
        scenarioContext.getMobileSearchPage().clickOnMapButton();
    }

    @And("I select a random hotel on the map")
    public void iSelectARandomHotelOnTheMap() throws InterruptedException {
        Thread.sleep(10000);
        scenarioContext.getMobileSearchPage().selectRandomHotelOnMap();
    }

    @And("I retrieve the name of the hotel")
    public void iRetrieveTheNameOfTheHotel() {
        scenarioContext.getMobileSearchPage().getHotelName();
    }

    @And("I retrieve the corresponding price")
    public void iRetrieveTheCorrespondingPrice() {
        scenarioContext.getMobileSearchPage().getHotelPrice();
    }

    @And("I add the hotel to my favorites")
    public void iAddTheHotelToMyFavorites() throws InterruptedException {
        Thread.sleep(3000);
        scenarioContext.getMobileSearchPage().addToFavorites();
    }

    @Then("I go back to the homescreen")
    public void iGoBackToTheHomescreen() {
        scenarioContext.getMobileSearchPage().returnToHomescreen();
    }

}

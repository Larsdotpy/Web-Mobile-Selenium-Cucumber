package trivago.stepdefinitions;

import io.cucumber.java.en.And;
import trivago.context.ScenarioContext;

public class HotelSearchPageStepDefinitions extends CucumberScenario{
    private final ScenarioContext scenarioContext;

    public HotelSearchPageStepDefinitions(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @And("The top {int} hotels are retrieved with their prices")
    public void theTopHotelsAreRetrievedWithTheirPrices(int top5) throws InterruptedException {
        scenarioContext.getHotelSearchPage().getTop5HotelNamesAndPrices();

        //Gaat nog iets mis, check functie van gettop5... voor details wat er mis gaat
    }
}

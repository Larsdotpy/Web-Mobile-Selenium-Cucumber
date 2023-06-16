package trivago.stepdefinitions.Web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import trivago.config.Constants;
import trivago.context.ScenarioContext;
import trivago.models.GuestAndRooms;
import trivago.stepdefinitions.CucumberScenario;

import java.util.Calendar;
import java.util.Date;

public class HomePageStepDefinitions extends CucumberScenario {
    private final ScenarioContext scenarioContext;

    public HomePageStepDefinitions(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Given("User navigates to the homepage")
    public void iMOnTheHomepageOfTrivago() {
        scenarioContext.getWebDriver().get(Constants.homepage);
    }

    @And("Cookie popup is displayed")
    public void CookiePopupIsDisplayed() {
        scenarioContext.getHomePage().cookiePopupIsDisplayed();
    }

    @And("User accepts cookie notification")
    public void UserAcceptsCookieNotification(){
        scenarioContext.getHomePage().doAllowCookies();
    }

    @When("^User types (.*) and presses ENTER$")
    public void UserEntersDestination(String destination) {
        scenarioContext.getHomePage().setDestination(destination);
        //Browser vult automatisch 'Amsterdam' in, na het waarnemen van de juiste waarde !
    }

    @And("User's arrival date is today")
    public void UserSelectsArrivalDateAsToday() {
        Date arrival = new Date();
        scenarioContext.setArrival(arrival);
        scenarioContext.getHomePage().setArrival(arrival);
    }

    @And("^User's depart date is (\\d+) day[s]? later$")
    public void UserSelectsDepartDate(String days) {
        Calendar c = Calendar.getInstance();
        c.setTime(scenarioContext.getArrival());
        c.add(Calendar.DATE, Integer.parseInt(days));
        Date departure = c.getTime();
        scenarioContext.setDeparture(departure);
        scenarioContext.getHomePage().setDeparture(departure);
    }

    @And("^User selects (\\d+) adult[s]?, (\\d+) child[r]?[e]?[n]? and (\\d+) room[s]?$")
    public void UserSelectsAmountOfAdultsAndChildrenAndRooms(String rooms, String adults, String children) {
        GuestAndRooms guestAndRooms = new GuestAndRooms(
                Integer.parseInt(adults),
                Integer.parseInt(children),
                Integer.parseInt(rooms)
        );
        scenarioContext.setGuestAndRooms(guestAndRooms);
        scenarioContext.getHomePage().setGuestAndRooms(guestAndRooms);
    }

    @Then("User presses the search button")
    public void UserPressesTheSearchButton() {
        scenarioContext.getHomePage().doSearch();
    }

    @And("User clicks on login button")
    public void userClicksOnLoginButton() {
        scenarioContext.getHomePage().clickLoginBtn();
    }

    @When("User clicks on valuta options")
    public void userClicksOnValutaOptions() {
        scenarioContext.getHomePage().clickCurrenyMenu();
    }

    @Then("All valuta options must consist of valutaList")
    public void allValutaOptionsMustConsistOfValutaList() {
        scenarioContext.getHomePage().checkCurrenyMenu();
    }
}

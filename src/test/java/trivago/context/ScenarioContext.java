package trivago.context;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import trivago.models.GuestAndRooms;
import trivago.pages.Mobile.MobileChromeBrowserPage;
import trivago.pages.Mobile.MobileHomePage;
import trivago.pages.Mobile.MobileOnboardingPage;
import trivago.pages.Mobile.MobileSettingsPage;
import trivago.pages.Web.HomePage;
import trivago.pages.Web.HotelSearchPage;
import trivago.pages.Web.LoginPage;

import java.util.Date;

@Data
public class ScenarioContext {
    private WebDriver webDriver;
    private AppiumDriver appiumDriver;
    private AppiumDriverLocalService service;
    private HomePage homePage;
    private LoginPage loginPage;
    private HotelSearchPage hotelSearchPage;
    private String destination;
    private Date arrival;
    private Date departure;
    private GuestAndRooms guestAndRooms;
    private MobileOnboardingPage mobileOnboardingPage;
    private MobileHomePage mobileHomePage;
    private MobileSettingsPage mobileSettingsPage;
    private MobileChromeBrowserPage mobileChromeBrowserPage;
}



//   De @ data annotatie maakt er automatisch getters en setters van
//   De variabelen zijn private voor security redenen. Nu kunnen ze alleen nog worden aangepast
//   middels getters en setters. Dit voorkomt het maken van fouten.


package trivago.context;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import trivago.models.GuestAndRooms;
import trivago.pages.HomePage;
import trivago.pages.LoginPage;

import java.util.Date;

@Data
public class ScenarioContext {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private String destination;
    private Date arrival;
    private Date departure;
    private GuestAndRooms guestAndRooms;
}



//   De @ data annotatie maakt er automatisch getters en setters van
//   De variabelen zijn private voor security redenen. Nu kunnen ze alleen nog worden aangepast
//   middels getters en setters. Dit voorkomt het maken van fouten.


package trivago.pages;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trivago.models.GuestAndRooms;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Slf4j
public class HomePage extends BasePage {
    @FindBy(id = "onetrust-banner-sdk")
    private WebElement cookiePopup;
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement allowCookies;

    @FindBy(css= "[data-testid='header-login']")
    private WebElement loginBtn;

    @FindBy(id= "currency-selector")
    private WebElement currencyMenu;

    private final By currencyOptions = By.xpath("//*[@id=\"currency-selector\"]/optgroup[2]/option");
    private final List<String> moneyType = Arrays.asList("AED", "ARS", "AUD", "AZN",
            "BGN", "BHD", "BRL", "CAD", "CHF", "CLP", "CNY", "COP", "CZK", "DKK", "DZD", "EGP",
            "EUR", "GBP", "HKD", "HRK", "HUF", "IDR", "ILS", "INR", "JOD", "JPY", "KRW", "KWD", "KZT",
            "LBP", "MAD", "MDL", "MXN", "MYR", "NGN", "NOK", "NZD", "OMR", "PEN", "PHP", "PLN", "QAR", "RON",
            "RSD", "RUB", "SAR", "SEK", "SGD", "THB", "TND", "TRY", "TWD", "UAH", "USD", "UYU", "VND", "ZAR");

    @FindBy(css = "[data-testid='search-form-destination']")
    private WebElement destination;

    @FindBy(css = "[data-testid='search-form-calendar-checkin']")
    private WebElement checkin;

    @FindBy(css = "[data-testid='search-form-calendar-checkout']")
    private WebElement checkout;

    @FindBy(css = "[data-testid='adults-amount']")
    private WebElement adultsAmount;

    @FindBy(css = "[data-testid='adults-amount-minus-button']")
    private WebElement minusAdults;

    @FindBy(css = "[data-testid='adults-amount-plus-button']")
    private WebElement plusAdults;

    @FindBy(css = "[data-testid='children-amount']")
    private WebElement childrenAmount;

    @FindBy(css = "[data-testid='children-amount-minus-button']")
    private WebElement minusChildren;

    @FindBy(css = "[data-testid='children-amount-plus-button']")
    private WebElement plusChildren;

    @FindBy(css = "[data-testid='rooms-amount']")
    private WebElement roomsAmount;

    @FindBy(css = "[data-testid='rooms-amount-minus-button']")
    private WebElement minusRooms;

    @FindBy(css = "[data-testid='rooms-amount-plus-button']")
    private WebElement plusRooms;

    @FindBy(css = "[data-testid='calendar-popover']")
    private WebElement calendarPopover;

    @FindBy(css = "[data-testid='guest-selector-popover']")
    private WebElement guestSelectorPopover;

    @FindBy(css = "[data-testid='guest-selector']")
    private WebElement guestSelector;

    @FindBy(css = "[data-testid='guest-selector-apply']")
    private WebElement guestSelectorApply;

    @FindBy(css = "[data-testid='search-button']")
    private WebElement searchButton;

    @FindBy(css = "[data-testid='accomodation-list-element]")
    private WebElement hotel;

    private WebElement getDayWebElement(Date day) {
        return wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(String.format("[data-testid='valid-calendar-day-%s']",
                        new SimpleDateFormat("yyyy-MM-dd").format(day))
                )
        ));
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void cookiePopupIsDisplayed(){
        Assertions.assertThat(wait.until(ExpectedConditions.visibilityOf(cookiePopup)).isDisplayed());
    }

    public void doAllowCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(allowCookies)).click();
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }

    public void clickCurrenyMenu(){
        currencyMenu.click();
    }

    public void checkCurrenyMenu(){
        List<WebElement> Options = driver.findElements(currencyOptions);
        System.out.println("Size: "+Options.size());

        List<String> valutaList = new ArrayList<>();

        for (WebElement element : Options
        ) {
            String i = element.getAttribute("value");
            valutaList.add(i);
        }

        System.out.println("List on website" + valutaList);
        System.out.println("List in database" + moneyType);

        Assertions.assertThat(valutaList.containsAll(moneyType));

    }

    public void setDestination(String destination) {
        this.destination.sendKeys(destination);
    }

    public void setArrival(Date arrival) {
        checkin.click();
        getDayWebElement(arrival).click();
    }

    public void setDeparture(Date departure) {
        if (!wait.until(ExpectedConditions.visibilityOf(calendarPopover)).isDisplayed()) {
            checkout.click();
        }
        getDayWebElement(departure).click();
    }

    public void setGuestAndRooms(GuestAndRooms guestAndRooms) {
        if (!wait.until(ExpectedConditions.visibilityOf(guestSelectorPopover)).isDisplayed()) {
            guestSelector.click();
        }

        int currentNrOfAdults = Integer.parseInt(adultsAmount.getAttribute("value"));
        log.info("Current number of adults: " + currentNrOfAdults);
        if (guestAndRooms.getNrOfAdults() > currentNrOfAdults) {
            for (int i = 0; i < (guestAndRooms.getNrOfAdults() - currentNrOfAdults); i++) {
                plusAdults.click();
            }
        } else if (guestAndRooms.getNrOfAdults() < currentNrOfAdults) {
            for (int i = 0; i < (Math.abs(guestAndRooms.getNrOfAdults() - currentNrOfAdults)); i++) {
                minusAdults.click();
            }
        }

        int currentNrOfChildren = Integer.parseInt(childrenAmount.getAttribute("value"));
        log.info("Current number of children: " + currentNrOfChildren);
        if (guestAndRooms.getNrOfChildren() > currentNrOfChildren) {
            for (int i = 0; i < (guestAndRooms.getNrOfChildren() - currentNrOfChildren); i++) {
                plusChildren.click();
            }
        } else if (guestAndRooms.getNrOfChildren() < currentNrOfChildren) {
            for (int i = 0; i < (Math.abs(guestAndRooms.getNrOfChildren() - currentNrOfChildren)); i++) {
                minusChildren.click();
            }
        }

        int currentNrOfRooms = Integer.parseInt(roomsAmount.getAttribute("value"));
        log.info("Current number of rooms: " + currentNrOfRooms);
        if (guestAndRooms.getNrOfRooms() > currentNrOfRooms) {
            for (int i = 0; i < (guestAndRooms.getNrOfRooms() - currentNrOfRooms); i++) {
                plusRooms.click();
            }
        } else if (guestAndRooms.getNrOfRooms() < currentNrOfRooms) {
            for (int i = 0; i < (Math.abs(guestAndRooms.getNrOfRooms() - currentNrOfRooms)); i++) {
                minusRooms.click();
            }
        }
        guestSelectorApply.click();
    }

    public void doSearch() {
        searchButton.click();
    }

    public void getTop5HotelNamesAndPrices() throws InterruptedException {
        Thread.sleep(30000); //Vanwege anti-bot protection

        List<WebElement> hotelList = driver.findElements(By.cssSelector("span[itemprop='name']"));
        List<WebElement> priceList = driver.findElements(By.cssSelector("p[data-testid='recommended-price'"));

        for (int i = 1; i < 6; i++) {
                System.out.println("Hotel " + i + ": " + hotelList.get(i).getText() +
                        "    " + priceList.get(i).getText());
        }
    }
    //Bij de bovenstaande functie gaat iets nog niet helemaal goed. Hij pakt niet de top5, maar pakt van de bovenste
    //3 verschillende prijzen lijkt het. Eventueel heten id's dus hetzelfde in de DOM
    //Dit nog uitzoeken
}

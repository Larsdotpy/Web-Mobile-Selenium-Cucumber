package trivago.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Slf4j
public class HotelSearchPage extends BasePage{
    public HotelSearchPage(WebDriver driver) {
        super(driver);
    }

    public void getTop5HotelNamesAndPrices() throws InterruptedException {
        Thread.sleep(30000); //Vanwege anti-bot protection

        List<WebElement> hotelList = driver.findElements(By.cssSelector("[data-testid='item-name']"));
        List<WebElement> priceList = driver.findElements(By.cssSelector("[data-testid='recommended-price'"));

        for (int i = 0; i < 5; i++) {
            System.out.println("Hotel " + (i + 1) + ": " + hotelList.get(i).getText() +
                    "    " + priceList.get(i).getText());
        }
    }
}

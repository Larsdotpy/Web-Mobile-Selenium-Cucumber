package trivago.pages.Mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

@Slf4j
public class MobileSearchPage extends MobileBasePage{

    public MobileSearchPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.trivago:id/mapButton")
    private WebElement mapBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView[1]")
    private WebElement hotelName;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]")
    private WebElement hotelPrice;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ImageView")
    private WebElement favoriteBtn;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private WebElement backToHomescreenBtn;

    public void clickOnMapButton(){
        clickElement(mapBtn);
    }

    public void selectRandomHotelOnMap(){
        Random random = new Random();
        int randomNumber = random.nextInt(20) + 1;

        String xpath = "//android.view.View[@content-desc=\"Google Map\"]/android.view.View[" + randomNumber + "]";
        WebElement randomHotel = driver.findElement(By.xpath(xpath));

        clickElement(randomHotel);
    }

    public void getHotelName(){
        System.out.println(hotelName.getText());
    }

    public void getHotelPrice(){
        System.out.println(hotelPrice.getText());
    }

    public void addToFavorites(){
        clickElement(favoriteBtn);
    }

    public void returnToHomescreen(){
        clickElement(backToHomescreenBtn);
    }
}

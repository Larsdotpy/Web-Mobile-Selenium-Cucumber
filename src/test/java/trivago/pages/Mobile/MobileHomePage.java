package trivago.pages.Mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class MobileHomePage extends MobileBasePage{

    MobileSearchPage mobileSearchPage;

    @AndroidFindBy(id = "com.trivago:id/fragmentHomeLogoImageView")
    @iOSXCUITFindBy(accessibility = "x")
    private WebElement homeLogo;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Settings\"]/android.widget.FrameLayout/android.widget.ImageView")
    private WebElement settingsBtn;

    @AndroidFindBy(id = "android:id/button2")
    private WebElement notNowBtn;

    @AndroidFindBy(id = "com.trivago:id/fragmentHomeExpandedDealformSearchTextView")
    private WebElement searchHotelBtn;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Favorites\"]/android.widget.FrameLayout[2]/android.widget.ImageView")
    private WebElement favoriteBtn;

    public MobileHomePage(AppiumDriver driver) {
        super(driver);
    }

    public void homescreenLogoIsDisplayed() {
        isDisplayed(homeLogo);
    }

    public void clickOnSettings(){
        clickElement(settingsBtn);
    }

    public void clickOnNotNow(){
        clickElement(notNowBtn);
    }

    public void clickOnSearchHotelBtn(){
        clickElement(searchHotelBtn);
    }

    public void clickOnFavoriteBtn(){
        clickElement(favoriteBtn);
    }

}

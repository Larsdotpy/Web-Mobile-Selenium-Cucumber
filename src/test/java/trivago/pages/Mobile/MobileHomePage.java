package trivago.pages.Mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

@Slf4j
public class MobileHomePage extends MobileBasePage{
    @AndroidFindBy(id = "com.trivago:id/fragmentHomeLogoImageView")
    @iOSXCUITFindBy(accessibility = "x")
    private WebElement homeLogo;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Settings\"]/android.widget.FrameLayout/android.widget.ImageView")
    private WebElement settingsBtn;

    public MobileHomePage(AppiumDriver driver) {
        super(driver);
    }

    public void homescreenLogoIsDisplayed() {
        isDisplayed(homeLogo);
    }

    public void clickOnSettings(){
        clickButton(settingsBtn);
    }

}

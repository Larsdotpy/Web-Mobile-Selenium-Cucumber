package trivago.pages.Mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
@Slf4j
public class MobileOnboardingPage extends MobileBasePage{
    @AndroidFindBy(id = "com.trivago:id/activityPlatformSelectionConfirmButton")
    @iOSXCUITFindBy(accessibility = "x")
    private WebElement btnConfirm;

    @AndroidFindBy(id = "com.trivago:id/activityCookieConsentContentAcceptButton")
    private WebElement btnAcceptAll;

    @AndroidFindBy(id = "com.trivago:id/skipButton")
    private WebElement btnSkipAlerts;

    public MobileOnboardingPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickConfirm() {
        clickElement(btnConfirm);
    }
    public void acceptCookies(){
        clickElement(btnAcceptAll);
    }

    public void skipPriceAlertsNotification(){
        clickElement(btnSkipAlerts);
    }
}

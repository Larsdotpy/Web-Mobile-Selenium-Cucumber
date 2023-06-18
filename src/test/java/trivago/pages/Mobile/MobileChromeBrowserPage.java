package trivago.pages.Mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

@Slf4j
public class MobileChromeBrowserPage extends MobileBasePage{

    @AndroidFindBy(id = "com.android.chrome:id/terms_accept")
    @iOSXCUITFindBy(accessibility = "x")
    private WebElement acceptAndContinueBtn;

    @AndroidFindBy(id = "com.android.chrome:id/negative_button")
    private WebElement declineTurnOnSyncBtn;

    @AndroidFindBy(id = "email")
    private WebElement emailInputField;

    @AndroidFindBy(id = "password")
    private WebElement passwordInputField;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button[2]")
    private WebElement loginBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.widget.Button")
    private WebElement nextBtn;

    public MobileChromeBrowserPage(AppiumDriver driver) {
        super(driver);
    }

    public void acceptAndContinue(){
        clickButton(acceptAndContinueBtn);
    }

    public void declineTurnOnSync(){
        clickButton(declineTurnOnSyncBtn);
    }

    public void inputInvalidEmail(){
        clickButton(emailInputField);
        emailInputField.sendKeys("invalidEmail@test.com");
        clickButton(nextBtn);
    }

    public void inputInvalidPassword(){
        clickButton(passwordInputField);
        passwordInputField.sendKeys("INVALIDPASSWORD");
        clickButton(loginBtn);
    }

    public void pressLoginBtn(){
        clickButton(loginBtn);
    }
}

package trivago.pages.Mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

@Slf4j
public class MobileBrowserPage extends MobileBasePage{

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText")
    private WebElement emailInputField;
    //xpath, since id did not work. Otherwise ID is always preferred

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.widget.EditText")
    private WebElement passwordInputField;
    //xpath, since id did not work. Otherwise ID is always preferred


    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.widget.Button[2]")
    private WebElement loginBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button")
    private WebElement nextBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.widget.Button")
    private WebElement editProfileBtn;

    public MobileBrowserPage(AppiumDriver driver) {
        super(driver);
    }

    public void inputValidEmail(){
        clickButton(emailInputField);
        emailInputField.sendKeys("xmyjjubreazemcsfqu@tpwlb.com");
    }

    public void pressNext(){
        clickButton(nextBtn);
    }

    public void inputValidPassword(){
        clickButton(passwordInputField);
        passwordInputField.sendKeys("ABCDEFGHIJKL123");
    }

    public void pressLoginBtn(){
        clickButton(loginBtn);
    }

    public void checkSuccessfullyLoggedIn() throws InterruptedException {
        Thread.sleep(5000); //This is not good practice, but wait until visibility of element does not seem to work.
        isDisplayed(editProfileBtn);

        //TODO User stays logged in, even after reset by appium in after step. NEEDS TO BE FIXED!
    }
}

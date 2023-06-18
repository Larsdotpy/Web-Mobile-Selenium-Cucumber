package trivago.pages.Mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

@Slf4j
public class MobileSettingsPage extends MobileBasePage{

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "x")
    private WebElement loginBtn;

    public MobileSettingsPage(AppiumDriver driver) {
        super(driver);
    }

    public void goToLoginScreen(){
        clickButton(loginBtn);
    }

}

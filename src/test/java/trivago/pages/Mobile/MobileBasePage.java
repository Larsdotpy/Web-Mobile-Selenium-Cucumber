package trivago.pages.Mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static trivago.config.Constants.MAX_IMPLICIT_WAIT;

public abstract class MobileBasePage {
        protected final WebDriver driver;
        protected final WebDriverWait wait;

        public MobileBasePage(AppiumDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_IMPLICIT_WAIT));
            PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(MAX_IMPLICIT_WAIT)), this);
        }

        public void clickButton(WebElement webElement) {
            wait.until(ExpectedConditions.visibilityOf(webElement)).click();
        }
}

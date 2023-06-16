package trivago.pages.Web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static trivago.config.Constants.MAX_IMPLICIT_WAIT;

public class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;


    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_IMPLICIT_WAIT));
        PageFactory.initElements(driver, this);
    }

}

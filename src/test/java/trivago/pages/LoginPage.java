package trivago.pages;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;


@Slf4j
public class LoginPage extends BasePage{

    @FindBy(css= "[data-testid='email-input']")
    private WebElement emailInputField;

    @FindBy(css= "[data-testid='form-field-error-notification']")
    private WebElement errorNotification;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterInvalidEmail(){
        //emailInputField.sendKeys("Invalid email", Keys.RETURN);
        driver.findElement(By.cssSelector("[data-testid='email-input']")).sendKeys("Invalid email", Keys.RETURN);
    }

    public void errorNotificiationIsDisplayed(){
        Assertions.assertThat(errorNotification).isEqualTo("Voer je volledige e-mailadres in. Bijvoorbeeld: naam@voorbeeld.com");
    }

    public void errorNotificationIsOfdb3734HexValue(){
        String msg = errorNotification.getCssValue("color");
        String color = Color.fromString(msg).asHex();
        Assertions.assertThat(color).isEqualTo("#db3734");
    }
}

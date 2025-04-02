package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage{

    public LogoutPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h1")
    WebElement logout_message;

    public String verify_logout_message()
    {
        return logout_message.getText();
    }
}

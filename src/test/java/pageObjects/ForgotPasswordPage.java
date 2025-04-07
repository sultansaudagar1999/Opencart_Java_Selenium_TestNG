package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage{

    public ForgotPasswordPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@name=\"email\"]")
    WebElement email_box;

    @FindBy(xpath = "//input[@value=\"Continue\"]")
    WebElement continue_button;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement error_message;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement succes_message;


    public void clickContinue()
    {
        continue_button.click();
    }

    public void enterEmail(String email)
    {
        email_box.sendKeys(email);
    }

    public String errorMessage()
    {
        return error_message.getText();
    }

    public String successMessage()
    {
        return succes_message.getText();
    }



}

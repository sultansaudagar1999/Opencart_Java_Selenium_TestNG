package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{


    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    // ✅ Locators
    @FindBy(linkText = "Continue")
    WebElement registerLnk;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginBtn;

    @FindBy(xpath = "//*[@id='content']/h2[1]")
    WebElement myAccount;

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myAccountDropdown;

    @FindBy(linkText = "Logout")
    WebElement logoutLnk;

    @FindBy(linkText = "Forgotten Password")
    WebElement forgotPasswordLnk;

    @FindBy(linkText = "Register")
    WebElement registerLnkTxt;

    @FindBy(css = "body:nth-child(2) div.container:nth-child(4) > div.alert.alert-danger.alert-dismissible")
    WebElement warningMsg;

    @FindBy(linkText = "Change your password")
    WebElement changePasswordLnk;

    @FindBy(linkText = "Continue")
    WebElement newCustomerContinueBtn;

    @FindBy(xpath = "//*[@id='content']/h1")
    WebElement registerPage;

    @FindBy(xpath = "//*[@id='account-login']/ul")
    WebElement breadcrumb;

    @FindBy(css = "h2")
    WebElement pageHeading;



    // ✅ Actions (Methods)

    public void clickContinueButton() {
        registerLnk.click();
    }

    public void enterEmail(String emailInput) {
        email.clear();
        email.sendKeys(emailInput);
    }

    public void enterPassword(String pwd) {
        password.clear();
        password.sendKeys(pwd);
    }

    public void clearEmail() {
        email.clear();
    }

    public void clearPassword() {
        password.clear();
    }

    public String getEmailPlaceholder() {
        return email.getAttribute("placeholder");
    }

    public String getPasswordPlaceholder() {
        return password.getAttribute("placeholder");
    }

    public void clickLogin() {
        loginBtn.click();
    }

    public boolean isLoginButtonDisplayed() {
        return loginBtn.isDisplayed();
    }

    public boolean isMyAccountPageDisplayed() {
        try {
            return myAccount.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickMyAccountDropdown() {
        myAccountDropdown.click();
    }

    public void clickLogout() {
        logoutLnk.click();
    }

    public boolean isLogoutPresent() {
        return logoutLnk.isDisplayed();
    }

    public void clickForgotPassword() {
        forgotPasswordLnk.click();
    }

    public void clickRegister() {
        registerLnkTxt.click();
    }

    public boolean isRegisterPageDisplayed() {
        return registerPage.isDisplayed();
    }

    public String getWarningMessage() {
        return warningMsg.getText();
    }

    public String getPasswordBoxType() {
        return password.getAttribute("type");
    }

    public WebElement getPasswordField() {
        return password;
    }

    public void clickChangePassword() {
        changePasswordLnk.click();
    }

    public void clickNewCustomerContinue() {
        newCustomerContinueBtn.click();
    }

    public String getBreadcrumbText() {
        return breadcrumb.getText();
    }

    public String getPageHeadingText() {
        return pageHeading.getText();
    }


}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage{


    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="//span[normalize-space()='My Account']")
    WebElement lnkMyaccount;

    @FindBy(xpath="//a[normalize-space()='Register']")
    WebElement lnkRegister;

    @FindBy(linkText = "Login")   // Login link added in step5
    WebElement linkLogin;

    @FindBy(xpath = "//input[@name=\"search\"]" )
    WebElement searchbox;

    @FindBy(xpath = "//div[@id=\"search\"]//span/button" )
    WebElement searchbutton;

    @FindBy(xpath = "//div[@class=\"caption\"]//a")
    List<WebElement> list_search_items;



    public void clickMyAccount()
    {
        lnkMyaccount.click();
    }

    public void clickRegister()
    {
        lnkRegister.click();
    }

    public void clickLogin()
    {
        linkLogin.click();
    }

    public void enter_into_searchbox(String search)
    {
       searchbox.sendKeys(search);
    }

    public void click_search_button()
    {
        searchbutton.click();
    }

    public List<WebElement> search_items()
    {
        return list_search_items;
    }







}
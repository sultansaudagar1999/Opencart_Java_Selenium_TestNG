package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.PublicKey;

public class ProductPage extends BasePage{

    public ProductPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@class=\"btn-group\"]//button[2]")
    WebElement compareButton;

    @FindBy(xpath = "//a[text()=\"product comparison\"]")
    WebElement succesCompareLink;


    public void clickCompareButton(){
        compareButton.click();
    }


    public void clickSuccesLink(){
        succesCompareLink.click();
    }



}

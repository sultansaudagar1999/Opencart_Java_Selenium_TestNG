package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductComparePage extends BasePage{

    public ProductComparePage(WebDriver driver){
        super(driver);
    }


    @FindBy(xpath = "//div[@id=\"content\"]//h1")
    WebElement productPage;

    public String verifyProductPage(){
        return productPage.getText();
    }
}

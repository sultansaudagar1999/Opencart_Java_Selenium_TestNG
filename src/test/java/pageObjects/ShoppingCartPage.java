package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage
{
    public ShoppingCartPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "(//div[@class=\"pull-left\" or text()=\"Continue Shopping\"])[2]")
    WebElement continueShoppingButton;



    public void clickContinueShoppingButton(){
        continueShoppingButton.click();
    }
}

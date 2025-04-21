package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends BasePage {


    public SearchResultPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@class=\"caption\"]//h4/a")
    List<WebElement> productsDisplayedList;

    public List<WebElement> productDisplayedAfterSearch(){
        return productsDisplayedList;
    }

}

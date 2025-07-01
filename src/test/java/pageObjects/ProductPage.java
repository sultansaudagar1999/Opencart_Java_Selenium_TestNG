package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends BasePage{

    public ProductPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@class=\"btn-group\"]//button[2]")
    WebElement compareButton;

    @FindBy(xpath = "//a[text()=\"product comparison\"]")
    WebElement succesCompareLink;

    @FindBy(xpath = "//div[@class=\"button-group\"]//button[1]")
    WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement succesMessageAddtoCart;

    @FindBy(xpath = "//button[@data-original-title=\"Add to Wish List\"]")
    WebElement addToWishlistButton;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement succesMessageAddToWishlist;

    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement shoppingCartLink;



    public void clickCompareButton(){
        compareButton.click();
    }


    public void clickSuccesLink(){
        succesCompareLink.click();
    }

    public void addToCartButton(){
        addToCartButton.click();
    }


    public String successMessageAddtoCart(){
        return succesMessageAddtoCart.getText();
    }

    public void AddToWishlistButton(){
        addToWishlistButton.click();
    }

    public String successMessageAddToWishlist(){
        return succesMessageAddToWishlist.getText();
    }

    public void clickShoppingCartLinkAfterProductAdd(){
        shoppingCartLink.click();
    }



}

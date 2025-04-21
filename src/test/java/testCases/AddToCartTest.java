package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import testBase.BaseClass;

public class AddToCartTest extends BaseClass {

    @Test(priority = 1, groups = {"sanity", "regression", "master"})
    void addToCartTest() {

        logger.info("***** Starting Add to Cart Test *****");

        HomePage hp = new HomePage(driver);
        String productName = p.getProperty("existing_product");

        logger.info("Searching for product: " + productName);
        hp.enter_into_searchbox(productName);
        hp.click_search_button();

        ProductPage pp = new ProductPage(driver);
        logger.info("Clicking on 'Add to Cart' button.");
        pp.addToCartButton();

        logger.info("Verifying success message after adding product to cart...");
        String expectedMessage = "Success: You have added iMac to your shopping cart!\n×";
        String actualMessage = pp.successMessageAddtoCart();

        logger.info("Expected Message: " + expectedMessage);
        logger.info("Actual Message: " + actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Add to Cart message did not match!");

        logger.info("***** Completed Add to Cart Test *****");
    }
}

package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import testBase.BaseClass;

public class AddtoWishListTest extends BaseClass {

    @Test(priority = 1, groups = {"sanity", "regression", "master"})
    void addToWishlistTest() {

        logger.info("***** Starting Add to Wishlist Test *****");

        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        logger.info("Clicked on My Account.");

        hp.clickLogin();
        logger.info("Navigated to Login Page.");

        LoginPage lp = new LoginPage(driver);
        lp.enterEmail(p.getProperty("email"));
        lp.enterPassword(p.getProperty("password"));
        lp.clickLogin();
        logger.info("Logged in with valid credentials.");

        String productName = p.getProperty("existing_product");
        logger.info("Searching for product: " + productName);
        hp.enter_into_searchbox(productName);
        hp.click_search_button();

        ProductPage pp = new ProductPage(driver);
        logger.info("Clicking on 'Add to Wishlist' button.");
        pp.AddToWishlistButton();

        logger.info("Verifying success message for adding to wishlist...");
        String expectedMessage = "Success: You have added iMac to your wish list!\n×";
        String actualMessage = pp.successMessageAddToWishlist();

        logger.info("Expected Message: " + expectedMessage);
        logger.info("Actual Message: " + actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Add to Wishlist message did not match!");

        logger.info("***** Completed Add to Wishlist Test *****");
    }
}

package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class HomePageAfterAddingProductTest extends BaseClass {

    @Test(priority = 1, groups = {"sanity", "regression", "master"})
    public void verifyReturnToHomePageAfterAddingProduct() {
        try {
            logger.info("***** Starting Test: verifyReturnToHomePageAfterAddingProduct *****");

            // Step 1: Search for the product
            HomePage homePage = new HomePage(driver);
            String productName = p.getProperty("existing_product");
            logger.info("Searching for product: " + productName);
            homePage.enter_into_searchbox(productName);
            homePage.click_search_button();

            // Step 2: Add product to cart
            ProductPage productPage = new ProductPage(driver);
            logger.info("Clicking on 'Add to Cart' button.");
            productPage.addToCartButton();

            // Step 3: Navigate to shopping cart
            logger.info("Clicking on 'Shopping Cart' link.");
            productPage.clickShoppingCartLinkAfterProductAdd();

            // Step 4: Click on 'Continue Shopping'
            ShoppingCartPage cartPage = new ShoppingCartPage(driver);
            logger.info("Clicking on 'Continue Shopping' button.");
            cartPage.clickContinueShoppingButton();

            // Step 5: Validate Home Page Title
            logger.info("Validating if user is on the Home Page.");
            String expectedTitle = "Your Store";
            String actualTitle = driver.getTitle();

            logger.info("Expected Title: " + expectedTitle);
            logger.info("Actual Title: " + actualTitle);
            Assert.assertEquals(actualTitle, expectedTitle, "User is not on Home Page after continue shopping.");

            logger.info("***** Test Passed: User returned to Home Page successfully after adding product *****");

        } catch (Exception e) {
            logger.error("Test Failed: Exception occurred - " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}

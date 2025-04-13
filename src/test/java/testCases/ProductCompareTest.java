package testCases;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.ProductPage;
import pageObjects.SearchResultPage;
import testBase.BaseClass;

import java.util.List;

public class ProductCompareTest extends BaseClass {

    @Test(priority = 1, groups = {"regression", "master"})
    void testProductCompare() {

        logger.info("***** Starting Product Compare Test *****");

        HomePage hp = new HomePage(driver);
        logger.info("Searching for product: " + p.getProperty("existing_product"));
        hp.enter_into_searchbox(p.getProperty("existing_product"));
        hp.click_search_button();

        SearchResultPage srp = new SearchResultPage(driver);
        List<WebElement> productList = srp.productDisplayedAfterSearch();
        boolean productFound = false;

        for (WebElement product : productList) {
            if (product.getText().equalsIgnoreCase(p.getProperty("existing_product"))) {
                logger.info("Product found in search results: " + product.getText());
                product.click();
                productFound = true;
                break;
            }
        }

        Assert.assertTrue(productFound, "Product not found in the search results!");

        ProductPage pp = new ProductPage(driver);
        pp.clickCompareButton();
        logger.info("Clicked on 'Compare this Product' button.");

        pp.clickSuccesLink();
        logger.info("Navigated to comparison success link.");

        ProductComparePage pcp = new ProductComparePage(driver);
        String actualTitle = pcp.verifyProductPage();
        String expectedTitle = "Product Comparison";

        logger.info("Verifying comparison page title...");
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");

        logger.info("***** Completed Product Compare Test *****");
    }
}

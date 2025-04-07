package testCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseClass;
import java.util.List;

public class SearchFunctionalityTest extends BaseClass {

    @Test(priority = 1, groups = {"sanity", "master"})
    void verifySearchWithExistingProduct() {
        logger.info("**** Started verifySearchWithExistingProduct ****");

        HomePage hp = new HomePage(driver);
        String expectedProduct = p.getProperty("existing_product");

        logger.info("Searching for existing product: " + expectedProduct);
        hp.enter_into_searchbox(expectedProduct);
        hp.click_search_button();

        List<WebElement> searchResults = hp.search_items();
        boolean found = searchResults.stream()
                .anyMatch(item -> item.getText().equalsIgnoreCase(expectedProduct));

        Assert.assertTrue(found, "The expected product was NOT found in search results!");
        logger.info("Product found in search results: " + expectedProduct);

        logger.info("**** Exited verifySearchWithExistingProduct ****");
    }

    @Test(priority = 2, groups = {"sanity", "master"})
    void verifySearchWithNonExistingProduct() {
        logger.info("**** Started verifySearchWithNonExistingProduct ****");

        HomePage hp = new HomePage(driver);
        String nonExistingProduct = p.getProperty("non_existing_product");

        logger.info("Searching for non-existing product: " + nonExistingProduct);
        hp.enter_into_searchbox(nonExistingProduct);
        hp.click_search_button();

        List<WebElement> searchResults = hp.search_items();
        Assert.assertTrue(searchResults.isEmpty(),
                "Search results are NOT empty for a non-existing product: " + nonExistingProduct);

        logger.info("No results displayed for non-existing product as expected.");
        logger.info("**** Exited verifySearchWithNonExistingProduct ****");
    }
}

package testCases;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseClass;
import java.util.List;

public class SearchFunctionalityTest extends BaseClass {

    @Test(priority = 1,groups = {"sanity","master"})
    void verifySearchWithExistingProduct() {
        logger.info("**** Search with existing product started ****");
        HomePage hp = new HomePage(driver);
        hp.enter_into_searchbox(p.getProperty("existing_product"));
        hp.click_search_button();

        List<WebElement> searchResults = hp.search_items();
        boolean found = false;

        for (WebElement x : searchResults) {
            if (p.getProperty("existing_product").equalsIgnoreCase(x.getText())) {
                found = true;
                break;
            }
        }

        Assert.assertTrue(found, "The expected product was NOT found in search results!");
        logger.info("**** Search with existing product exited ****");
    }

    @Test(priority = 2,groups = {"sanity","master"})
    void verifySearchWithNonExistingProduct() {
        logger.info("**** Search with non-existing product started ****");
        HomePage hp = new HomePage(driver);
        hp.enter_into_searchbox(p.getProperty("non_existing_product"));
        hp.click_search_button();

        List<WebElement> searchResults = hp.search_items();

        // Search result should be empty if product does not exist
        Assert.assertTrue(searchResults.isEmpty(), "Search results are NOT empty for a non-existing product!");
        logger.info("**** Search with non-existing product exited ****");
    }
}

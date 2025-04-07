package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass {

    @Test(groups = {"sanity", "master"})
    public void testUserLoginFunctionality() {

        logger.info("**** Started LoginTest ****");

        HomePage hp = new HomePage(driver);
        logger.info("Clicking My Account");
        hp.clickMyAccount();

        logger.info("Navigating to Login Page");
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        logger.info("Entering login credentials");
        lp.enterEmail(p.getProperty("email"));
        lp.enterPassword(p.getProperty("password"));

        logger.info("Clicking on Login");
        lp.clickLogin();

        logger.info("Verifying if My Account page is displayed");
        Assert.assertTrue(lp.isMyAccountPageDisplayed(), "Login failed or My Account page not displayed");

        logger.info("**** Exited LoginTest ****");
    }
}

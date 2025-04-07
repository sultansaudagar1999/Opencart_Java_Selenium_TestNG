package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import testBase.BaseClass;

public class LogoutTest extends BaseClass {

    @Test(groups = {"sanity", "master"})
    public void testUserLogoutFunctionality() {
        logger.info("Starting Logout Test");

        HomePage hp = new HomePage(driver);
        logger.info("Clicking on My Account");
        hp.clickMyAccount();

        logger.info("Navigating to Login Page");
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        logger.info("Entering email and password");
        lp.enterEmail(p.getProperty("email"));
        lp.enterPassword(p.getProperty("password"));

        logger.info("Clicking on Login button");
        lp.clickLogin();

        logger.info("Clicking on Logout");
        lp.clickLogout();

        LogoutPage lg = new LogoutPage(driver);
        logger.info("Verifying logout success message");

        Assert.assertEquals(
                lg.verify_logout_message(),
                "Account Logout",
                "Logout message not matched. Logout may have failed."
        );

        logger.info("Logout Test Passed");
    }
}

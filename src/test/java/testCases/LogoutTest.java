package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import testBase.BaseClass;

public class LogoutTest extends BaseClass {

    @Test(groups = {"sanity","master"})
    public void verifyUserCanLogout()
    {
        logger.info("**** Logout test started ****");
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();
        LoginPage lp = new LoginPage(driver);
        lp.enterEmail(p.getProperty("email"));
        lp.enterPassword(p.getProperty("password"));
        lp.clickLogin();
        lp.clickLogout();
        LogoutPage lg = new LogoutPage(driver);
        Assert.assertEquals(lg.verify_logout_message(),"Account Logout");
        logger.info("**** Logout test exited ****");


    }
}

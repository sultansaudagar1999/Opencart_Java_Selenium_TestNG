package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass {

    @Test(groups = {"sanity","master"})
    void verifyUserCanLogin(){

        logger.info("**** Started LoginTest ****");
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.enterEmail(p.getProperty("email"));
        lp.enterPassword(p.getProperty("password"));
        lp.clickLogin();

        Assert.assertTrue(lp.isMyAccountPageDisplayed());
        logger.info("**** Exited LoginTest ****");

    }
}

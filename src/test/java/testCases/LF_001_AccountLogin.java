package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class LF_001_AccountLogin extends BaseClass {

    @Test
    void LF_001_AccountLogin_test(){

        logger.info("**** LF_001_AccountLogin_test Started ****");
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.enterEmail(p.getProperty("email"));
        lp.enterPassword(p.getProperty("password"));
        lp.clickLogin();

        Assert.assertTrue(lp.isMyAccountPageDisplayed());
        logger.info("**** LF_001_AccountLogin_test Exited ****");

    }



}

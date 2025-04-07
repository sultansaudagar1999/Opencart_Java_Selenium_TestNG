package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class ForgotPasswordTest extends BaseClass {

    @Test(priority = 1, groups = {"sanity", "master"})
    public void correct_email_forgot() {

        logger.info("***** Starting Forgot Password Test: Correct Email *****");

        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.clickForgotPassword();

        ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
        fpp.enterEmail(p.getProperty("email"));
        fpp.clickContinue();

        String expectedMsg = "An email with a confirmation link has been sent your email address.";
        String actualMsg = fpp.successMessage();
        logger.info("Success Message: " + actualMsg);

        Assert.assertEquals(actualMsg, expectedMsg, "Success message not matched!");

        logger.info("***** Completed Forgot Password Test: Correct Email *****");
    }

    @Test(priority = 2, groups = {"regression", "master"})
    public void incorrect_email_forgot() {

        logger.info("***** Starting Forgot Password Test: Incorrect Email *****");

        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.clickForgotPassword();

        ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
        fpp.enterEmail("invalid@example.com");
        fpp.clickContinue();

        String expectedMsg = "Warning: The E-Mail Address was not found in our records, please try again!";
        String actualMsg = fpp.errorMessage();
        logger.warn("Error Message: " + actualMsg);

        Assert.assertEquals(actualMsg, expectedMsg, "Warning message not matched!");

        logger.info("***** Completed Forgot Password Test: Incorrect Email *****");
    }

    @Test(priority = 3, groups = {"regression", "master"})
    public void empty_email_forgot() {

        logger.info("***** Starting Forgot Password Test: Empty Email *****");

        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.clickForgotPassword();

        ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
        fpp.clickContinue();

        String expectedMsg = "Warning: The E-Mail Address was not found in our records, please try again!";
        String actualMsg = fpp.errorMessage();
        logger.warn("Error Message: " + actualMsg);

        Assert.assertEquals(actualMsg, expectedMsg, "Warning message not matched!");

        logger.info("***** Completed Forgot Password Test: Empty Email *****");
    }
}

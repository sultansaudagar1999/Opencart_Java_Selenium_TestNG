package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class RegistrationTest extends BaseClass {

    @Test(groups = {"regression", "master"})
    public void verifyUserCanRegister() {
        logger.info("**** Started RegistrationTest ****");

        HomePage hp = new HomePage(driver);
        logger.info("Navigating to Registration Page");
        hp.clickMyAccount();
        hp.clickRegister();

        RegisterPage rp = new RegisterPage(driver);

        // Test Data
        String firstName = "Sultan";
        String lastName = "Saudagar";
        String email = random_email();
        String phone = random_mobile();
        String pwd = random_password();

        logger.info("Filling registration form");
        rp.setFirstName(firstName);
        rp.setLastName(lastName);
        rp.setEmail(email);
        rp.setTelephone(phone);
        rp.setPassword(pwd);
        rp.setConfirmPassword(pwd);
        rp.setPrivacyPolicy();
        rp.clickContinue();

        logger.info("Verifying registration success message");
        Assert.assertEquals(rp.getConfirmationMsg(), "Your Account Has Been Created!",
                "Registration failed or confirmation message mismatch");

        logger.info("**** Exited RegistrationTest ****");
    }
}

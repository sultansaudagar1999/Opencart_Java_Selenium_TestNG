package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class RegistrationTest extends BaseClass {

    @Test(groups = {"regression","master"})
    public void verifyUserCanRegister()
    {
        logger.info("**** Started RegistrationTest ****");
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickRegister();

        RegisterPage rp = new RegisterPage(driver);
        rp.setFirstName("Sultan");
        rp.setLastName("Saudagar");
        rp.setEmail(random_email());
        rp.setTelephone(random_mobile());
        String pwd = random_password();
        rp.setPassword(pwd);
        rp.setConfirmPassword(pwd);
        rp.setPrivacyPolicy();
        rp.clickContinue();
        Assert.assertEquals(rp.getConfirmationMsg(),"Your Account Has Been Created!");

        logger.info("**** Exited RegistrationTest ****");


    }
}
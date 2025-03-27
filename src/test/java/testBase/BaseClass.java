package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseClass {

    public static WebDriver driver;
    @BeforeClass
    public void setup()
    {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,SECONDS);
        driver.get("https://naveenautomationlabs.com/opencart/");
        driver.manage().window().maximize();
    }

    public String random_email()
    {
        String email = RandomStringUtils.randomAlphabetic(5);
        return email+"502@gmail.com";
    }

    public String random_mobile()
    {
        String mobile = RandomStringUtils.randomNumeric(10);
        return mobile;

    }

    public String random_password()
    {
        String str1 = RandomStringUtils.randomAlphabetic(4);
        String str2 = RandomStringUtils.randomNumeric(3);
        return (str1+"@"+str2);
    }

    @AfterClass
    public void teardown()
    {
        driver.quit();
    }
}

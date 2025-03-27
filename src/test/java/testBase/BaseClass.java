package testBase;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseClass {

    public static WebDriver driver;
    public Logger logger;
    @BeforeClass
    @Parameters({"os","browser"})
    public void setup(String os,String br)
    {
        switch (br.toLowerCase())
        {
            case "chrome":driver=new ChromeDriver(); break;
            case "edge":driver=new EdgeDriver(); break;
            case "firefox":driver=new FirefoxDriver(); break;
            default:  System.out.println("Invalid Browser Name...!");return;

        }
        logger = LogManager.getLogger(this.getClass());
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

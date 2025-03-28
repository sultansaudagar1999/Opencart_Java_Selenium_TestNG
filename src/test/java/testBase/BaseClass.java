package testBase;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseClass {

    public Logger logger;
    public WebDriver driver;// Moved inside the class, not static
    public Properties p;

    @BeforeMethod
    @Parameters({"os", "browser"})
    public void setup(
            @Optional("windows") String os,     // Add @Optional with default value
            @Optional("chrome") String br) throws IOException      // Add @Optional with default value
    {
        FileReader file = new FileReader(".\\src\\test\\resources\\config.properties");
        p=new Properties();
        p.load(file);


        logger = LogManager.getLogger(this.getClass());

        if (br.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (br.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (br.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid browser specified. Launching Chrome by default.");
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.get(p.getProperty("baseURL"));
        driver.manage().window().maximize();
    }


    public String random_email() {
        return RandomStringUtils.randomAlphabetic(5) + "502@gmail.com";
    }

    public String random_mobile() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String random_password() {
        return RandomStringUtils.randomAlphabetic(4) + "@" + RandomStringUtils.randomNumeric(3);
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

package testBase;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseClass {

    public Logger logger;
    public WebDriver driver;// Moved inside the class, not static
    public Properties p;

    @BeforeMethod(groups = {"sanity","regression","master"})
    @Parameters({"os", "browser"})
    public void setup(
            @Optional("windows") String os,
            @Optional("chrome") String br) throws IOException
    {
        logger = LogManager.getLogger(this.getClass());
        FileReader file = new FileReader(".\\src\\test\\resources\\config.properties");
        p=new Properties();
        p.load(file);

        if(p.getProperty("execution_env").equalsIgnoreCase("remote")){
            DesiredCapabilities cap = new DesiredCapabilities();
            //OS
            if(os.equalsIgnoreCase("windows")){
                cap.setPlatform(Platform.WIN10);
            }
            else if (os.equalsIgnoreCase("mac")) {
                cap.setPlatform(Platform.MAC);
            }
            else if (os.equalsIgnoreCase("linux")) {
                cap.setPlatform(Platform.LINUX);
            }
            else {
                System.out.println("No Matching OS....!");
                return;
            }

            //Browser
            if(br.equalsIgnoreCase("chrome")){
                cap.setBrowserName("chrome");
            }
            else if (br.equalsIgnoreCase("edge")){
                cap.setBrowserName("edge");
            }
            else if (br.equalsIgnoreCase("firefox")){
                cap.setBrowserName("firefox");
            }

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);

        }
        if(p.getProperty("execution_env").equalsIgnoreCase("local")){
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

    @AfterMethod(groups = {"sanity","regression","master"})
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }

}

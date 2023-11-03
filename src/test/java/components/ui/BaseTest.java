package components.ui;

import com.ui.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utilities.ReadPropertyFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

///This class provide the initialization of base set up methods like Weddriver setup before the test triggers///
public class BaseTest  {
    ReadPropertyFile fr = new ReadPropertyFile();
       private final static Logger logger = LoggerFactory.getLogger(BasePage.class);
    WebDriver driver;

    ///This method will set up the driver and return it///
    public WebDriver getDriver() throws IOException {

        String browser =  fr.getPropertyValue("browser");

        Path resourceDirectory = Paths.get("src","test","resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();

        if(browser.equalsIgnoreCase("chrome")) {
            String[] pathNames = {absolutePath, "\\drivers\\chromedriver.exe" };
            String path = String.join(File.pathSeparator, pathNames);
            System.out.println(path);
            System.setProperty("webdriver.chrome.driver",path.replaceAll(";",""));
            ChromeOptions options = new ChromeOptions();
            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            options.addArguments("--remote-allow-origins=*");
            options.setCapability("ignore-certificate-errors", true);


            driver = new ChromeDriver(options);
        }
        return driver;
    }
    /// Close the Browser///
    public void driverClose()
    {
        this.driver.close();
        logger.info("Webdriver Closed successfully");

    }
    public void driverSetUp() throws IOException {
        this.driver=getDriver();
           }



///Initialize the Webdriver///

}

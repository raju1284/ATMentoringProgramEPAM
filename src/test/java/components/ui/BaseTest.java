package components.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.EventRecodingLogger;
import utilities.readPropertyFile;


import java.io.IOException;

import static org.openqa.selenium.remote.CapabilityType.PROXY;

public class BaseTest {
    public static WebDriver driver;
    readPropertyFile fr = new readPropertyFile();
    private final static Logger logger = LoggerFactory.getLogger(BaseTest.class);

    public WebDriver getDriver() throws IOException {
        String browser="";
      if (driver==null)
      {
           browser =  fr.getPropertyValue("browser");
      }
      if (browser.equalsIgnoreCase("edge"))
        {

            System.setProperty("webdriver.edge.driver",
                    System.getProperty("user.dir")+"\\"+"src\\test\\resources\\drivers\\msedgedriver.exe");

            EdgeOptions options = new EdgeOptions();
            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            options.addArguments("--remote-allow-origins=*");
            options.setCapability("ignore-certificate-errors", true);

            WebDriverManager.edgedriver().avoidResolutionCache().proxy(PROXY).setup();
            driver = new EdgeDriver(options);


        }
      return driver;
    }

    public void navigateToUrl(String url)
    {
        driver.get(url);
        logger.info("open the Report portal Successful");
    }

    public String getTitle()
    {
        return driver.getTitle();
    }

    public void driverClose()
    {
        driver.close();
        logger.info("Webdriver Closed successfully");

    }
}

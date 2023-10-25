package runners;

import components.ui.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.readPropertyFile;

import java.io.IOException;

import static org.openqa.selenium.remote.CapabilityType.PROXY;

public class TestNGRunner extends BaseTest {
    readPropertyFile fr = new readPropertyFile();
    public WebDriver driver;
@BeforeTest
    public void driverSetup() throws IOException {

        String browser =  fr.getPropertyValue("browser");

        if (browser.equalsIgnoreCase("edge"))
        {
            try {
                System.setProperty("webdriver.edge.driver",
                        System.getProperty("user.dir") + "\\" + "src\\test\\resources\\drivers\\msedgedriver.exe");

                EdgeOptions options = new EdgeOptions();
                options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                options.addArguments("--remote-allow-origins=*");
                options.setCapability("ignore-certificate-errors", true);

                WebDriverManager.edgedriver().avoidResolutionCache().proxy(PROXY).setup();
                this.driver = new EdgeDriver(options);
            }
            catch (Exception exp){
                exp.printStackTrace();
            }
        }
          }

    @Test
    public void openTheReportUrl() throws IOException {
        navigateToUrl(driver, fr.getPropertyValue("reportPortal"));
        Assert.assertEquals(getPageTitle(driver), "Report Portal");

    }
    @AfterTest
            public void cleanUp(){
        driver.close();
    }

}

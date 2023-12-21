package components.ui;

import com.ui.BasePage;
import com.ui.DashboardPage;
import com.ui.LoginReportPortalPage;
import com.ui.WidgetPage;
import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
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
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

///This class provide the initialization of base set up methods like Weddriver setup before the test triggers///
public class BaseTest {
    public ReadPropertyFile fr = new ReadPropertyFile();
    private final static Logger logger = LoggerFactory.getLogger(BasePage.class);
    protected WebDriver driver = getDriver();

    public LoginReportPortalPage loginReportPortalPage = new LoginReportPortalPage(driver);
    public DashboardPage dashboardPage = new DashboardPage(driver);
    public WidgetPage widgetPage = new WidgetPage(driver);

    public BaseTest() throws IOException {
    }

    ///This method will set up the driver and return it///
    public WebDriver getDriver() throws IOException {
        String nodeURL = "http://192.168.4.23:4444/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WIN10);
        driver = new RemoteWebDriver(new URL(nodeURL), capabilities);
        return driver;
    }

    /// Close the Browser///

    public void driverClose() {
        this.driver.close();
        logger.info("Webdriver Closed successfully");
    }
}


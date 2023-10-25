package components.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.EventRecodingLogger;
import utilities.readPropertyFile;


import java.io.IOException;
import java.time.Duration;

import static org.openqa.selenium.remote.CapabilityType.PROXY;

public class BaseTest {
    public static WebDriver driver;
    readPropertyFile fr = new readPropertyFile();
    private final static Logger logger = LoggerFactory.getLogger(BaseTest.class);

    public void BaseTest(WebDriver driver)
    {
        this.driver = driver;
    }


    public void navigateToUrl(WebDriver driver,String url)
    {
        driver.get(url);
        logger.info("open the Report portal Successful");
    }

    public String getPageTitle(WebDriver driver)
    {
        return driver.getTitle();
    }

    public void driverClose(WebDriver driver)
    {
        driver.close();
        logger.info("Webdriver Closed successfully");

    }
    public void doClick(WebDriver driver, String locator) {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       WebElement elementToClick ;
       elementToClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
       elementToClick.click();

    }

    public void sendKeys(WebDriver driver, String locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elementToSendKeys ;
        elementToSendKeys = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        elementToSendKeys.sendKeys(text);
    }
}

package com.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.openqa.selenium.remote.CapabilityType.PROXY;
///This class will provide the Base page common methods and initializing the Webdriver ///
public class BasePage {
    protected WebDriver driver;

    private final static Logger logger = LoggerFactory.getLogger(BasePage.class);
    private WebDriverWait wait;
    ///Initializing the Web driver and wait time////
    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }
    /// This method will perform the action of navigate to specific given url///
    public void navigateToUrl(String url)
    {
        driver.get(url);
        logger.info("open the Report portal Successful");
    }

    public String getPageTitle()
    {
        return driver.getTitle();
    }

/// This method will perform the action of Webelements Click///
    public void doClick( String locator) {
        WebElement elementToClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        elementToClick.click();
    }
    /// This method will perform the action of sendkeys to a textbox Webelements///
    public void sendKeys(String locator, String text) {
        WebElement elementToSendKeys = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        elementToSendKeys.sendKeys(text);
    }
}

package com.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.openqa.selenium.remote.CapabilityType.PROXY;
///This class will provide the Base page common methods and initializing the Webdriver ///
public class BasePage {
    protected WebDriver driver;

    private final static Logger logger = LoggerFactory.getLogger(BasePage.class);
    private static WebDriverWait wait;
    ///Initializing the Web driver and wait time////
    public BasePage(WebDriver driver)
    {
        this.driver = driver;

    }

    public static void waitForElement(WebDriver driver, WebElement element) {
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(element));
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
        waitForElement(driver, driver.findElement(By.xpath(locator)));
        WebElement elementToCLick= driver.findElement(By.xpath(locator));
        elementToCLick.click();
    }
    /// This method will perform the action of sendkeys to a textbox Webelements///
    public void sendKeys(String locator, String text) {
        waitForElement(driver, driver.findElement(By.xpath(locator)));
        WebElement elementToSendKeys = driver.findElement(By.xpath(locator));
        elementToSendKeys.sendKeys(text);
    }
}

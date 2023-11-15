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
import utilities.ReadPropertyFile;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.remote.CapabilityType.PROXY;

///This class will provide the Base page common methods and initializing the Webdriver ///
public class BasePage {
    public static WebDriver driver;

    private final static Logger logger = LoggerFactory.getLogger(BasePage.class);
    private static WebDriverWait wait;

    ///Initializing the Web driver and wait time////
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElement(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeInvisible(By locator, String text) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
    }


    /// This method will perform the action of navigate to specific given url///
    public void navigateToUrl(String url) {
        this.driver.get(url);
        logger.info("open the Report portal Successful");
    }

    public String getPageTitle() {
        return this.driver.getTitle();
    }

    /// This method will perform the action of Webelements Click///
    public void doClick(By locator) {
        waitForElement(locator);
        WebElement elementToCLick = driver.findElement(locator);
        elementToCLick.click();
    }

    /// This method will perform the action of sendkeys to a textbox Webelements///
    public void sendKeys(By locator, String text) {
        waitForElement(locator);
        WebElement elementToSendKeys = driver.findElement(locator);
        elementToSendKeys.sendKeys(text);
    }

    public String getElementText(By locator) {
        waitForElement(locator);
        WebElement elementGetText = driver.findElement(locator);
        return elementGetText.getText();
    }

    public List<WebElement> getLsitsOfElements(By locator) {
        return driver.findElements(locator);
    }
}

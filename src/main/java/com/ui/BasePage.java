package com.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.ReadPropertyFile;

import java.io.IOException;
import java.time.Duration;

import static org.openqa.selenium.remote.CapabilityType.PROXY;

public class BasePage {
    public static WebDriver driver;

    private final static Logger logger = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
    }



    public void navigateToUrl(String url)
    {
        driver.get(url);
        logger.info("open the Report portal Successful");
    }

    public String getPageTitle()
    {
        return driver.getTitle();
    }

    public void driverClose()
    {
        driver.close();
        logger.info("Webdriver Closed successfully");

    }
    public void doClick( String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elementToClick ;
        elementToClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        elementToClick.click();

    }

    public void sendKeys(String locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elementToSendKeys ;
        elementToSendKeys = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        elementToSendKeys.sendKeys(text);
    }
}

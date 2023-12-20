package com.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideWait;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.TakeScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class BasePageSelenide {
    public static WebDriver driver;
    private static SelenideWait wait;
    public void waitForElement(By locator) {
        Configuration.timeout = 50000;
        Wait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void navigateToUrl(String url) {
        open(url);
    }

    public String getPageTitle() {
        return title();
    }

    public void doClick(By locator) {
        waitForElement(locator);
        $(locator).click();
    }

    public void sendKeys(By locator, String text) {
        waitForElement(locator);
        $(locator).sendKeys(text);
    }

    public String getElementText(By locator) {
        waitForElement(locator);
        return $(locator).getText();
    }

    public void fluentWaitSelenide(Long milliseconds) {
        wait = new SelenideWait(driver, milliseconds, 10);
    }

    public void takeScreenShotSelenide(String fileName) {
        String pngFileName = screenshot(fileName);
    }

    public void jsClick(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        waitForElement(locator);
        js.executeScript("arguments[0].click();", $(locator));
    }

    public void jsScrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("window.scrollBy(0,50)");
    }

}


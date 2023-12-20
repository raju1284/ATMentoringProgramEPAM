package com.ui;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.PageLoadWait;

import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Condition.text;

public class LoginPageSelenide extends BasePageSelenide {

    ///Report portal Login Page Locators and respective page methods will be coded here///
    By userName = By.xpath("//input[@name='login']");
    By password = By.xpath("//input[@name='password']");
    By loginButton = By.xpath("//button[@type='submit']");
    By loginWithEPAM = By.xpath("//button/span ");
    By userProfile = By.xpath("//div[@class='userBlock__user-block--Hrr33']");
    By userProfileElements = By.xpath("//div[@class='userBlock__menu--FHvby']/div");

    By welcomeText = By.xpath("//span[text()='Welcome,']");
    By notificationList = By.xpath("//div[@class='notificationList__notification-list--UEF9s']/div");
    By allDashboardsElement = By.xpath("//span[text()='All Dashboards']");

    public void enterUserCredentialsSelenide(String loginUser, String loginPassword) {
        sendKeys(userName, loginUser);
        sendKeys(password, loginPassword);
    }

    public void clickLoginButtonSelenide() throws Exception {
        doClick(loginButton);
        doClick(notificationList);
    }

    public void loginToReportPortalSelenide(String url, String userName, String password) throws Exception {
        navigateToUrl(url);
        enterUserCredentialsSelenide(userName, password);
        clickLoginButtonSelenide();
    }

    public void logoutSelenide() throws Exception {
        doClick(userProfile);
        waitForElement(userProfileElements);
        Selenide.$$(userProfileElements).findBy(text("Logout")).click();
    }

    public String notificationMessageSelenide() {
        return getElementText(notificationList);
    }

    public String allDashboardsTextSelenide() {
        return getElementText(allDashboardsElement);
    }
}

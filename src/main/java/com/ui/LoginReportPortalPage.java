package com.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.PageLoadWait;

import java.io.IOException;
import java.util.List;

public class LoginReportPortalPage extends BasePage {

    ///Report portal Login Page Locators and respective page methods will be coded here///
    By userName = By.xpath("//input[@name='login']");
    By password = By.xpath("//input[@name='password']");
    By loginButton = By.xpath("//button[@type='submit']");
    By loginWithEPAM = By.xpath("//button/span ");
    By userProfile = By.xpath("//div[@class='userBlock__user-block--Hrr33']");
    By userProfileElements = By.xpath("//div[@class='userBlock__menu--FHvby']/div");
    By notificationList = By.xpath("//div[@class='notificationList__notification-list--UEF9s']/div");

    public LoginReportPortalPage(WebDriver driver) {
        super(driver);
    }

    public void enterUserCredentials(String loginUser, String loginPassword) throws InterruptedException {

        sendKeys(userName, loginUser);
        sendKeys(password, loginPassword);
    }

    public void clickLoginButton() throws Exception {
        doClick(loginButton);
        doClick(notificationList);
    }

    public void loginToReportPortal(String url, String userName, String password) throws Exception {
        navigateToUrl(url);
        enterUserCredentials(userName, password);
        clickLoginButton();
    }

    public void logout() throws Exception
    {
        doClick(userProfile);
        waitForElement(userProfileElements);
        List<WebElement> profileWebElements = driver.findElements(userProfileElements);
        for (int i = 0; i < profileWebElements.size(); i++) {
            if (profileWebElements.get(i).getText().equalsIgnoreCase("Logout")) {
                profileWebElements.get(i).click();
                break;
            }
        }
    }

    public String notificationMessage() {
        return getElementText(notificationList);
    }
}

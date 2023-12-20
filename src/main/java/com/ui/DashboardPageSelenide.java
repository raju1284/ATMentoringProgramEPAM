package com.ui;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.text;

public class DashboardPageSelenide extends BasePageSelenide {
    By dashboardMenu = By.xpath("//i[@class='sidebarButton__btn-icon--xc3y6']");
    By dashboardAddNewButton = By.xpath("//i[@class='ghostButton__icon--Y8b6g']");
    By dashboardName = By.xpath("//input[@placeholder='Enter dashboard name']");
    By dashboardDescription = By.xpath("//textarea[@placeholder='Enter dashboard description']");
    By dashboardSave = By.xpath("//button[text()='Add']");
    By notificationList = By.xpath("//div[@class='notificationList__notification-list--UEF9s']/div");

    By deleteDashboardNameList = By.xpath("//div[@class='gridRow__grid-row--X9wIq']/a");
    By deleteList = By.xpath("//div[@class='gridRow__grid-row--X9wIq']//div[@class='dashboardTable__icon-holder--zZvuZ']/i");
    By deleteButton = By.xpath("//div/button[text()='Delete']");

    By projectList = By.xpath("//div[@class='projectSelector__projects-list--EKkEN']//a/span");
    By projectMenu = By.xpath("//div[@class='projectSelector__project-selector--C4soz']");
    By searchInput = By.xpath("//input[@class='inputSearch__input--yreVU type-text']");
    By dashTitleElement = By.xpath("//li/span");
    By currentUser = By.xpath("//div[@class='userBlock__username--xTuSF']");
    By userProfile = By.xpath("//div[@class='userBlock__user-block--Hrr33']");

    public void addDashboardSelenide(String name, String description, String projectName) throws InterruptedException {
        doClick(dashboardMenu);
        selectProjectSelenide(projectName);
        WebDriverRunner.getWebDriver().navigate().refresh();
        doClick(dashboardAddNewButton);
        sendKeys(dashboardName, name);
        sendKeys(dashboardDescription, description);
        doClick(dashboardSave);
        doClick(notificationList);
    }

    public void deleteDashboardSelenide(String dashName, String projectName) {
        doClick(dashboardMenu);
        selectProjectSelenide(projectName);
        waitForElement(deleteList);
        ElementsCollection delList = Selenide.$$(deleteList);
        ElementsCollection dashNameList = Selenide.$$(deleteDashboardNameList);
        for (int i = 0; i < delList.size(); i++) {
            for (int j = 0; j < dashNameList.size(); j++) {
                if (dashNameList.findBy(text(dashName)).exists()) ;
                {
                    delList.get(i).click();
                    doClick(deleteButton);
                    doClick(notificationList);
                    break;
                }
            }
            break;
        }
    }

    public void editDashboardSelenide(String dashName) {
        doClick(dashboardMenu);
        waitForElement(deleteDashboardNameList);
        ElementsCollection dashNameList = Selenide.$$(deleteDashboardNameList);
        for (int j = 0; j < dashNameList.size(); j++) {
            if (dashNameList.findBy(text(dashName)).exists()) {
                dashNameList.get(j).click();
                break;
            }
        }
    }

    public void selectProjectSelenide(String projectName) {
        doClick(projectMenu);
        ElementsCollection projList = Selenide.$$(projectList);
        for (int i = 0; i < projList.size(); i++) {
            if (projList.findBy(text(projectName)).exists()) {
                projList.findBy(text(projectName)).click();
                break;
            }
        }
    }


    public boolean dashboardDeletedSelenide(String dashName) {
        doClick(dashboardMenu);
        selectProjectSelenide(getProjectNameSelenide());
        waitForElement(deleteDashboardNameList);
        ElementsCollection dashNameList = Selenide.$$(deleteDashboardNameList);
        for (int j = 0; j < dashNameList.size(); j++) {
            if (dashNameList.findBy(text(dashName)).exists()) {
                return false;
            }
        }
        return true;
    }


    public String getDashboardTitleSelenide() {
        waitForElement(dashTitleElement);
        return getElementText(dashTitleElement);
    }

    public String getProjectNameSelenide() {
        doClick(userProfile);
        WebElement element = Selenide.$(currentUser);
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(element).perform();
        String hoverText = element.getText();
        return hoverText + "_PERSONAL";
    }


    public By getDashboardAddNewButton() {
        return dashboardAddNewButton;
    }
}

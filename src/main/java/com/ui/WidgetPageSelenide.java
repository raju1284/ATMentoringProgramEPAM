package com.ui;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WidgetPageSelenide extends BasePageSelenide {
    By dashboardMenu = By.xpath("//i[@class='sidebarButton__btn-icon--xc3y6']");
    By clickAddWidgetButton = By.xpath("//button/span[text()='Add new widget']");
    By selectConfigRadio = By.xpath("//div/label/span/div");
    By clickNextStepButton = By.xpath("//button/span[text()='Next step']");
    By selectDemoFilterRadio = By.xpath("//div[@class='filtersItem__filter-item--DHlV9']//span[text()='DEMO_FILTER']");
    By enterWidgetName = By.xpath("//input[@placeholder='Enter widget name']");
    By enterWidgetDes = By.xpath("//textarea[@placeholder='Enter widget description']");
    By saveWidget = By.xpath("//button[text()='Add']");
    By notificationList = By.xpath("//div[@class='notificationList__notification-list--UEF9s']/div");

    By widgetTitle = By.xpath("//div[@class='widgetHeader__widget-name-block--AOAHS']");


    public void addWidgetSelenide(String widgetName, String widgetDes, String filterType) {
        doClick(clickAddWidgetButton);
        ElementsCollection filterRadios = Selenide.$$(selectConfigRadio);
        for (int i = 0; i < filterRadios.size(); i++) {
            if (filterRadios.get(i).getText().equalsIgnoreCase(filterType)) {
                filterRadios.get(i).click();
                break;
            }
        }
        doClick(clickNextStepButton);
        doClick(selectDemoFilterRadio);
        jsScrollDown();
        doClick(clickNextStepButton);
        Selenide.$(enterWidgetDes).clear();
        Selenide.$(enterWidgetDes).clear();
        sendKeys(enterWidgetName, widgetName);
        sendKeys(enterWidgetDes, widgetDes);
        doClick(saveWidget);
        doClick(notificationList);

    }

    public String getWidgetTitleSelenide() {
        waitForElement(widgetTitle);
        return getElementText(widgetTitle);

    }
}

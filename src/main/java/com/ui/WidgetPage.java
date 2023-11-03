package com.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WidgetPage extends  BasePage {


    public WidgetPage(WebDriver driver) {
        super(driver);
    }
    By dashboardMenu=By.xpath("//i[@class='sidebarButton__btn-icon--xc3y6']");
    By clickAddWidgetButton= By.xpath("//button/span[text()='Add new widget']");
    By selectConfigRadio =By.xpath("//div/label/span/div");
    By clickNextStepButton=By.xpath("//button/span[text()='Next step']");
    By selectDemoFilterRadio=By.xpath("//div[@class='filtersItem__filter-item--DHlV9']//span[text()='DEMO_FILTER']");
    By enterWidgetName= By.xpath("//input[@placeholder='Enter widget name']");
    By enterWidgetDes =By.xpath("//textarea[@placeholder='Enter widget description']");
    By saveWidget=By.xpath("//button[text()='Add']");
    By notificationList= By.xpath("//div[@class='notificationList__notification-list--UEF9s']/div");

    public void addWidget(String widgetName, String widgetDes, String filterType) {

        doClick(clickAddWidgetButton);
            List<WebElement> filterRadios = getLsitsOfElements(selectConfigRadio);
            System.out.println(filterRadios.size());
        for (int i = 0; i < filterRadios.size(); i++) {
            System.out.println(filterRadios.size());
            if (filterRadios.get(i).getText().equalsIgnoreCase(filterType)) {
                filterRadios.get(i).click();
                break;
            }
        }
        doClick(clickNextStepButton);
        doClick(selectDemoFilterRadio);
        doClick(clickNextStepButton);
        driver.findElement(enterWidgetDes).clear();
        driver.findElement(enterWidgetDes).clear();
        sendKeys(enterWidgetName,widgetName);
        sendKeys(enterWidgetDes,widgetDes);
        doClick(saveWidget);
        doClick(notificationList);
        doClick(dashboardMenu);

    }

    }

package com.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class DashboardPage extends BasePage{
    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    By dashboardMenu=By.xpath("//i[@class='sidebarButton__btn-icon--xc3y6']");
    By dashboardAddNewButton=By.xpath("//span[text()='Add New Dashboard']");
    By dashboardName=By.xpath("//input[@placeholder='Enter dashboard name']");
    By dashboardDescription=By.xpath("//textarea[@placeholder='Enter dashboard description']");
    By dashboardSave=By.xpath("//button[text()='Add']");
    By notificationList= By.xpath("//div[@class='notificationList__notification-list--UEF9s']/div");

    By deleteDashboardNameList=By.xpath("//div[@class='gridRow__grid-row--X9wIq']/a");
    By deleteList=By.xpath("//div[@class='gridRow__grid-row--X9wIq']//div[@class='dashboardTable__icon-holder--zZvuZ']/i");
    By deleteButton=By.xpath("//div/button[text()='Delete']");

    By projectList=By.xpath("//div[@class='projectSelector__project-selector--C4soz projectSelector__shown--Bgnqy']//a/span");
    By projectMenu=By.xpath("//div[@class='projectSelector__project-selector--C4soz projectSelector__shown--Bgnqy']");
   By searchInput=By.xpath("//input[@class='inputSearch__input--yreVU type-text']");
    public void addDashboard(String name, String description) throws InterruptedException {
        doClick(dashboardMenu);
        Thread.sleep(5000);
        doClick(dashboardAddNewButton);
        sendKeys(dashboardName,name);
        sendKeys(dashboardDescription,description);
        doClick(dashboardSave);
        doClick(notificationList);
    }

    public void deleteDashboard(String dashName) throws InterruptedException {
        doClick(dashboardMenu);

        List<WebElement> delList= getLsitsOfElements(deleteList);
        List<WebElement> dashNameList= getLsitsOfElements(deleteDashboardNameList);

        for(int i=0; i< delList.size();i++){

            for (int j=0;j<dashNameList.size();j++) {

                if (dashNameList.get(j).getText().equalsIgnoreCase(dashName)) {
                    delList.get(i).click();
                    doClick(deleteButton);
                    doClick(notificationList);
                    break;
                }
            }
            break;
        }
    }


    public void editDashboard(String dashName)
    {
        doClick(dashboardMenu);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> dashNameList= getLsitsOfElements(deleteDashboardNameList);
         for (int j=0;j<dashNameList.size();j++) {
            if (dashNameList.get(j).getText().equalsIgnoreCase(dashName)) {
                dashNameList.get(j).click();
                break;
            }
        }
    }
    public void selectProject(String projectName)

    {
        doClick(projectMenu);
        List<WebElement> projList = driver.findElements(projectList);
        for(int i=0; i< projList.size();i++){
            if(projList.get(i).getText().equalsIgnoreCase(projectName))
            {
                projList.get(i).click();
                break;
            }
        }

    }

}

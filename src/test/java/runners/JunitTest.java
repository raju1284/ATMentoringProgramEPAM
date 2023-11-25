package runners;

import TestData.TestDataProvider;
import com.ui.DashboardPage;
import com.ui.LoginReportPortalPage;
import com.ui.WidgetPage;
import components.ui.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import utilities.ReadPropertyFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class JunitTest extends BaseTest {

    WebDriver driver = getDriver();

    static ReadPropertyFile fr = new ReadPropertyFile();
    String userName;
    String password;
    String dashboardName;
    String dashboardDes;
    String widgetName;
    String widgetDescription;
    String filterCriteria;
    LoginReportPortalPage loginReportPortalPage = new LoginReportPortalPage(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);
    WidgetPage widgetPage = new WidgetPage(driver);
    static TestDataProvider TD = new TestDataProvider();

    public JunitTest(String loginUser, String pwd, String dashName, String dashDes, String widgetName, String widgetDes, String filter) throws IOException {
        this.userName = loginUser;
        this.password = pwd;
        this.dashboardName = dashName;
        this.dashboardDes = dashDes;
        this.widgetName = widgetName;
        this.widgetDescription = widgetDes;
        this.filterCriteria = filter;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        return Arrays.asList(TD.testData());

    }

    @Test
    public void addDashboard() throws Exception {
        loginReportPortalPage.loginToReportPortal(fr.getPropertyValue("reportPortal"), fr.getPropertyValue("username1"), fr.getPropertyValue("password1"));
        Assert.assertEquals(loginReportPortalPage.notificationMessage(), "Signed in successfully");
        dashboardPage.addDashboard(dashboardName, dashboardDes,dashboardPage.getProjectName());
        Assert.assertEquals(loginReportPortalPage.notificationMessage(), "Dashboard has been added");
        dashboardPage.editDashboard(dashboardName);
        widgetPage.addWidget(widgetName, widgetDescription, filterCriteria);
        Assert.assertEquals(loginReportPortalPage.notificationMessage(), "Widget has been added");
        dashboardPage.deleteDashboard(dashboardName,dashboardPage.getProjectName());
        Assert.assertEquals(loginReportPortalPage.notificationMessage(), "Dashboard has been deleted");
        loginReportPortalPage.logout();
        driverClose();
    }
}

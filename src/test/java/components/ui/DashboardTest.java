package components.ui;

import TestData.TestDataProvider;
import com.ui.BasePage;
import com.ui.DashboardPage;
import com.ui.LoginReportPortalPage;
import com.ui.WidgetPage;
import io.cucumber.java.AfterAll;

import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class DashboardTest extends BaseTest {
    TestDataProvider testData = new TestDataProvider();
    private final static Logger logger = LoggerFactory.getLogger(LoginReportPortalTest.class);

    public DashboardTest() throws IOException {
    }

    @BeforeTest()
       public void loginReportPortal() throws Exception {
        loginReportPortalPage.loginToReportPortal(fr.getPropertyValue("reportPortal"), fr.getPropertyValue("username1"), fr.getPropertyValue("password1"));
        Assert.assertEquals(loginReportPortalPage.notificationMessage(), "Signed in successfully");
    }

    @Test(dataProvider = "provideAddDashboardData", priority = 1)
    public void addDashboard(String dashName, String dashDes) throws Exception {
        dashboardPage.addDashboard(dashName, dashDes,dashboardPage.getProjectName());
        Assert.assertEquals(loginReportPortalPage.notificationMessage(), "Dashboard has been added");
    }

    @Test(dataProvider = "provideAddDashboardData", priority = 3)
    public void deleteDashboard(String dashName, String dashDes) throws Exception {
        dashboardPage.deleteDashboard(dashName,dashboardPage.getProjectName());
        Assert.assertEquals(loginReportPortalPage.notificationMessage(), "Dashboard has been deleted");
    }

    @Test(dataProvider = "provideWidgetData", priority = 2)
    public void addWidget(String widgetName, String widgetDes, String filter) throws Exception {
        dashboardPage.editDashboard(fr.getPropertyValue("DashboardName1"));
        widgetPage.addWidget(widgetName, widgetDes, filter);
        Assert.assertEquals(loginReportPortalPage.notificationMessage(), "Widget has been added");
    }

    @DataProvider(name = "provideAddDashboardData")
    public Object[][] addDashboardTestData() throws IOException {
        return testData.addDashboardTestData();
    }

    @DataProvider(name = "provideWidgetData")
    public Object[][] addWidgetTestData() throws IOException {
        return testData.addWidgetTestData();
    }

    @Test(priority = 4)
    @AfterAll
    public void cleanUp() throws Exception {
        loginReportPortalPage.logout();
        driverClose();
    }
}

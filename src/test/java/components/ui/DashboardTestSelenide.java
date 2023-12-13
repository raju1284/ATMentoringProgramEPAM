package components.ui;

import TestData.TestDataProvider;
import com.codeborne.selenide.testng.ScreenShooter;
import io.cucumber.java.AfterAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners({ScreenShooter.class})
public class DashboardTestSelenide extends BaseSelenideTest {
    TestDataProvider testData = new TestDataProvider();
    private final static Logger logger = LoggerFactory.getLogger(LoginReportPortalTest.class);

    public DashboardTestSelenide() throws IOException {
    }

    @BeforeTest()
    public void loginReportPortal() throws Exception {
        ScreenShooter.captureSuccessfulTests = true;
        loginPageSelenide.loginToReportPortalSelenide(fr.getPropertyValue("reportPortal"), fr.getPropertyValue("username1"), fr.getPropertyValue("password1"));
        Assert.assertEquals(loginPageSelenide.notificationMessageSelenide(), "Signed in successfully");
    }

    @Test(dataProvider = "provideAddDashboardData", priority = 1)
    public void addDashboard(String dashName, String dashDes) throws Exception {
        dashboardPageSelenide.addDashboardSelenide(dashName, dashDes, dashboardPageSelenide.getProjectNameSelenide());
        Assert.assertEquals(loginPageSelenide.notificationMessageSelenide(), "Dashboard has been added");
    }

    @Test(dataProvider = "provideAddDashboardData", priority = 3)
    public void deleteDashboard(String dashName, String dashDes) throws Exception {
        dashboardPageSelenide.deleteDashboardSelenide(dashName, dashboardPageSelenide.getProjectNameSelenide());
        Assert.assertEquals(loginPageSelenide.notificationMessageSelenide(), "Dashboard has been deleted");
    }

    @Test(dataProvider = "provideWidgetData", priority = 2)
    public void addWidget(String widgetName, String widgetDes, String filter) throws Exception {
        dashboardPageSelenide.editDashboardSelenide(fr.getPropertyValue("DashboardName1"));
        widgetPageSelenide.addWidgetSelenide(widgetName, widgetDes, filter);
        Assert.assertEquals(loginPageSelenide.notificationMessageSelenide(), "Widget has been added");
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
        loginPageSelenide.logoutSelenide();
        driverClose();
    }
}

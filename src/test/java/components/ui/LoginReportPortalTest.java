package components.ui;

import TestData.TestDataProvider;
import com.ui.BasePage;
import com.ui.LoginReportPortalPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.ReadPropertyFile;


import java.io.IOException;

///This class provide the different Report Portal service test using TestNG annotations
public class LoginReportPortalTest extends BaseTest {
    TestDataProvider testData = new TestDataProvider();
    private final static Logger logger = LoggerFactory.getLogger(LoginReportPortalTest.class);

    public LoginReportPortalTest() throws IOException {
    }

    @Test(dataProvider = "provideLoginTestData", priority = 1)
    public void testLogin(String userName, String pwd) throws Exception {
        loginReportPortalPage.loginToReportPortal(fr.getPropertyValue("reportPortal"), userName, pwd);
        Assert.assertEquals(loginReportPortalPage.notificationMessage(), "Signed in successfully");
        loginReportPortalPage.logout();

    }

    @DataProvider(name = "provideLoginTestData")
    public Object[][] loginTestData() throws IOException {
        return testData.loginTestData();
    }

    @Test(priority = 2)
    public void tearDown() {
        driverClose();
    }
}

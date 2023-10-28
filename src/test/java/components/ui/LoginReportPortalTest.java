package components.ui;

import com.ui.LoginReportPortalPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import java.io.IOException;
///This class provide the different Report Portal service test using TestNG annotations
public class LoginReportPortalTest  extends BaseTest {
    LoginReportPortalPage loginReportPortalPage;

    @Test
    public void testOpenTheReportUrl() throws IOException {
        loginReportPortalPage = new LoginReportPortalPage(driver);
        loginReportPortalPage.navigateToUrl(fr.getPropertyValue("reportPortal"));
        Assert.assertEquals(loginReportPortalPage.getPageTitle(), "Report Portal");

    }
    @AfterTest
    public void cleanUp(){
       driverClose();
    }
}

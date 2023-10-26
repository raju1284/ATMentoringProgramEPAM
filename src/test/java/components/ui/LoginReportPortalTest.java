package components.ui;

import com.ui.LoginReportPortalPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.ReadPropertyFile;

import java.io.IOException;

public class LoginReportPortalTest  extends BaseTest {

    ReadPropertyFile fr = new ReadPropertyFile();




    public void openTheReportUrl(WebDriver driver) throws IOException {
        LoginReportPortalPage loginReportPortalPage = new LoginReportPortalPage(driver);
        loginReportPortalPage.navigateToUrl(fr.getPropertyValue("reportPortal"));
        Assert.assertEquals(loginReportPortalPage.getPageTitle(), "Report Portal");

    }
}

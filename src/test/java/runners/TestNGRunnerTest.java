package runners;

import com.ui.LoginReportPortalPage;
import components.ui.BaseTest;
import components.ui.LoginReportPortalTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestNGRunnerTest extends LoginReportPortalTest {

    LoginReportPortalPage loginReportPortalPage;

    @BeforeTest
    public void driverSetup() throws IOException {
        loginReportPortalPage = new LoginReportPortalPage(setUp());
    }

    @Test
    public void testOpenTheReportUrl() throws IOException {

        openTheReportUrl(loginReportPortalPage);
    }

    @AfterTest
    public void cleanUp(){
        loginReportPortalPage.driverClose();
    }


}

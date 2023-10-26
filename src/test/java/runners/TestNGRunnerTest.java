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

    WebDriver driver;
    LoginReportPortalPage loginReportPortalPage;

    @BeforeTest
    public void driverSetup() throws IOException {
        this.driver = setUp();
    }

    @Test
    public void testOpenTheReportUrl() throws IOException {

        openTheReportUrl(driver);
    }

    @AfterTest
    public void cleanUp(){
        loginReportPortalPage = new LoginReportPortalPage(driver);
        loginReportPortalPage.driverClose();
    }


}

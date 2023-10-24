package runners;

import components.ui.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.readPropertyFile;

import java.io.IOException;

public class TestNGRunner extends BaseTest {
    readPropertyFile fr = new readPropertyFile();

    @Test
    public void openTheReportUrl() throws IOException {
       getDriver();
       navigateToUrl(fr.getPropertyValue("reportPortal"));
       Assert.assertEquals(getTitle(),"Report Portal");
       driverClose();
    }
}

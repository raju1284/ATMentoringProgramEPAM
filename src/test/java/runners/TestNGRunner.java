package runners;

import components.ui.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.readPropertyFile;

import java.io.IOException;

public class TestNGRunner extends BaseTest {
    readPropertyFile fr = new readPropertyFile();
    public static WebDriver driver;

    @Test
    public void openTheReportUrl() throws IOException {
        driver = getDriver();
        driver.get(fr.getPropertyValue("reportPortal"));
        Assert.assertEquals(driver.getTitle(), "Report Portal");
        driver.close();
    }
}

package components.ui;

import com.codeborne.selenide.Selenide;
import com.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import utilities.ReadPropertyFile;

import java.io.IOException;

public class BaseSelenideTest {

    public BaseSelenideTest() throws IOException {
    }

    public ReadPropertyFile fr = new ReadPropertyFile();
    private final static Logger logger = LoggerFactory.getLogger(BasePage.class);
    public LoginPageSelenide loginPageSelenide = new LoginPageSelenide();
    public DashboardPageSelenide dashboardPageSelenide = new DashboardPageSelenide();
    public WidgetPageSelenide widgetPageSelenide = new WidgetPageSelenide();

    public void driverClose() {
        Selenide.closeWebDriver();
        logger.info("Webdriver Closed successfully");
    }

}

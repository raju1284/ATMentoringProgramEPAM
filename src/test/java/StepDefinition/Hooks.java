package StepDefinition;

import com.ui.LoginReportPortalPage;
import cucumber.TestContext;
import io.cucumber.java.After;

import java.io.IOException;

public class Hooks {
    TestContext testContext;
    LoginReportPortalPage loginReportPortalPage;

    public Hooks(TestContext context) throws IOException {
        testContext = context;
        loginReportPortalPage = testContext.getPageObjectManager().getLoginReportPortalPage();
    }

   // @After
    public void cleanUp() throws Exception {
        loginReportPortalPage.logout();
        testContext.getWebDriverManager().closeDriver();
    }

}

package StepDefinition;

import com.ui.LoginReportPortalPage;
import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.ReadPropertyFile;

import java.io.IOException;

public class LoginTestSteps {

    TestContext testContext;
    LoginReportPortalPage loginReportPortalPage;
    public ReadPropertyFile fr = new ReadPropertyFile();

    public LoginTestSteps(TestContext context) throws IOException {
        testContext = context;
        loginReportPortalPage = testContext.getPageObjectManager().getLoginReportPortalPage();
    }

    @Given("User login the report portal with valid username {string} and password {string}")
    public void userLoginWithValidCredentials(String username, String password) throws Exception {
        loginReportPortalPage.navigateToUrl(fr.getPropertyValue("reportPortal"));
        loginReportPortalPage.enterUserCredentials(username, password);
        loginReportPortalPage.clickLoginButton();
    }

    @Then("Verify that user was logged in successful")
    public void validateTheLoginFunctionality() throws Exception {
        Assert.assertTrue(loginReportPortalPage.allDashboardsText().equalsIgnoreCase("All Dashboards"));
    }

}

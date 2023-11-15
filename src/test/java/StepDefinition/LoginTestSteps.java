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

    @Given("User open the report portal URL")
    public void userOpensTheReportPortal() throws IOException {
        loginReportPortalPage.navigateToUrl(fr.getPropertyValue("reportPortal"));
    }

    @When("User login the report portal with valid {string} and {string}")
    public void userLoginWithValidCredentials(String username, String password) throws Exception {
        loginReportPortalPage.enterUserCredentials(username, password);
    }

    @Then("Validate the Login should be successful")
    public void validateTheLoginFunctionality() throws Exception {
        loginReportPortalPage.clickLoginButton();
        Assert.assertEquals(loginReportPortalPage.notificationMessage(), "Signed in successfully");
    }

}

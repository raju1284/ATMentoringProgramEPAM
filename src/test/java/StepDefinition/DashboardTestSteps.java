package StepDefinition;

import com.ui.DashboardPage;
import com.ui.LoginReportPortalPage;
import com.ui.WidgetPage;
import cucumber.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.ReadPropertyFile;

import java.io.IOException;

public class DashboardTestSteps {

    TestContext testContext;
    LoginReportPortalPage loginReportPortalPage;
    DashboardPage dashboardPage;
    WidgetPage widgetPage;
    public ReadPropertyFile fr = new ReadPropertyFile();

    public DashboardTestSteps(TestContext context) throws IOException {
        testContext = context;
        loginReportPortalPage = testContext.getPageObjectManager().getLoginReportPortalPage();
        dashboardPage = testContext.getPageObjectManager().getDashboardPage();
        widgetPage = testContext.getPageObjectManager().getWidgetPage();
    }

    @Given("User login the report portal")
    public void userLogin() throws Exception {
        loginReportPortalPage.loginToReportPortal(fr.getPropertyValue("reportPortal"), fr.getPropertyValue("username1"), fr.getPropertyValue("password1"));
    }

    @When("User creates the dashboard with  given dashboard name {string} and description {string}")
    public void userEntersTheDashboardDetails(String dashname, String dashdesc) throws Exception {
        dashboardPage.addDashboard(dashname, dashdesc);
    }

    @Then("Verify the dashboard {string} added successfully")
    public void validateTheDashboardAdded( String dashName) {
        Assert.assertTrue(dashboardPage.getDashboardTitle().equalsIgnoreCase(dashName));

    }

    @When("User adds the widget to the dashboard with {string} {string} {string} {string}")
    public void addTheWidgetToDashboard(String DashName, String widgetName, String desc, String filter) {
        dashboardPage.editDashboard(DashName);
        widgetPage.addWidget(widgetName, desc, filter);
    }

    @Then("Verify the widget {string} added to the dashboard successfully")
    public void validateTheWidgetAdded(String widgetName) {
        Assert.assertTrue(widgetPage.getWidgetTitle().contains(widgetName));
    }

    @When("User deletes the dashboard {string}")
    public void deleteTheDashboard(String dashName) {
        dashboardPage.deleteDashboard(dashName);
    }

    @Then("Verify the dashboard {string} deleted successfully")
    public void validateDashboardDeleted(String dashName) {
        Assert.assertTrue(dashboardPage.dashboardDeleted(dashName));
    }
}



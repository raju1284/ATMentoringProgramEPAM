package StepDefinition;

import com.ui.DashboardPage;
import com.ui.LoginReportPortalPage;
import com.ui.WidgetPage;
import cucumber.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.ReadPropertyFile;
import utilities.SlackService;

import java.io.IOException;

public class DashboardTestSteps {

    TestContext testContext;
    LoginReportPortalPage loginReportPortalPage;
    DashboardPage dashboardPage;
    WidgetPage widgetPage;
    public ReadPropertyFile fr = new ReadPropertyFile();
    SlackService slackService = new SlackService();

    public DashboardTestSteps(TestContext context) throws IOException {
        testContext = context;
        loginReportPortalPage = testContext.getPageObjectManager().getLoginReportPortalPage();
        dashboardPage = testContext.getPageObjectManager().getDashboardPage();
        widgetPage = testContext.getPageObjectManager().getWidgetPage();
    }


    @When("User creates the dashboard with  given dashboard name {string} and description {string}")
    public void userEntersTheDashboardDetails(String dashname, String dashdesc) throws Exception {
        String projectName = dashboardPage.getProjectName();
        dashboardPage.addDashboard(dashname, dashdesc, projectName);
    }

    @Then("Verify the dashboard {string} added successfully")
    public void validateTheDashboardAdded(String dashName) {
        Assert.assertTrue(dashboardPage.getDashboardTitle().equalsIgnoreCase(dashName));

    }

    @When("User adds the widget to the dashboard with name: {string} widgetName: {string} widgetDesc: {string} and filter: {string}")
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
        String projectName = dashboardPage.getProjectName();
        dashboardPage.deleteDashboard(dashName, projectName);
    }

    @Then("Verify the dashboard {string} deleted successfully")
    public void validateDashboardDeleted(String dashName) {
        Assert.assertTrue(dashboardPage.dashboardDeleted(dashName));
    }
}



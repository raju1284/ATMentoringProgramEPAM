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

    @When("User clicks add dashboard button and enter the dashboard details {string} {string}")
    public void userEntersTheDashboardDetails(String dashname, String dashdesc) throws Exception {
        dashboardPage.addDashboard(dashname, dashdesc);
    }

    @Then("User should be able to add dashboard successfully")
    public void validateTheDashboardAdded() {
        Assert.assertEquals(loginReportPortalPage.notificationMessage(), "Dashboard has been added");

    }

    @When("User clicks edit dashboard button and add the widget details {string} {string} {string} {string}")
    public void addTheWidgetToDashboard(String DashName, String widgetName, String desc, String filter) {
        dashboardPage.editDashboard(DashName);
        widgetPage.addWidget(widgetName, desc, filter);
    }

    @Then("User should be able to add widget to the dashboard successfully")
    public void validateTheWidgetAdded() {
        Assert.assertEquals(loginReportPortalPage.notificationMessage(), "Widget has been added");
    }

    @When("User deletes the dashboard {string}")
    public void deleteTheDashboard(String dashName) {
        dashboardPage.deleteDashboard(dashName);
    }

    @Then("User should be able to delete  the dashboard successfully")
    public void validateDashboardDeleted() {
        Assert.assertEquals(loginReportPortalPage.notificationMessage(), "Dashboard has been deleted");
    }
}



package StepDefinition.api;

import api.requests.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.ReadPropertyFile;
import utilities.SharedData;

import java.io.IOException;

public class DashboardAPITestSteps {

    SharedData sharedData = new SharedData();
    ReadPropertyFile fr = new ReadPropertyFile();

    @When("User creates the dashboard with  given dashboard name {string} and description {string} under the Project {string}")
    public void userCreatesDashboardUsingAPIPost(String dashName, String dashDescription, String projectName) throws IOException {
        sharedData.setCreateDashboardRequest(CreateDashboardRequest.builder()
                .name(dashName)
                .description(dashDescription).build());
        sharedData.setResponse(sharedData.getServiceUtil().postResponseFromService(
                sharedData.getCreateDashboardRequest(), fr.getPropertyValue("PostDashboard.Url"), projectName, sharedData.getObjectMapper(), fr.getPropertyValue("AuthorizationToken")));
    }

    @Then("User receives {string} status code")
    public void validateTheResponseStatusCode(String statusCode) {
        Assert.assertEquals(statusCode, String.valueOf(sharedData.getResponse().statusCode()));
    }

    @And("User validates the error code {string} and message {string}")
    public void userValidateErrorMessage(String errorCode, String message) {
        Assert.assertEquals(errorCode, sharedData.getResponse().jsonPath().getString("errorCode"));
        Assert.assertEquals(message, sharedData.getResponse().jsonPath().getString("message"));
    }

    @When("User gets the dashboard with given dashboard Id {string}  under the Project {string}")
    public void userGetTheSpecifiedDashboard(String dashboardId, String projectName) throws IOException {
        sharedData.setResponse(sharedData.getServiceUtil().getResponseFromGetDashboard(
                fr.getPropertyValue("GetDashboard.Url"), projectName, dashboardId, fr.getPropertyValue("AuthorizationToken")));

    }

    @And("User validates the response name {string} and description {string}")
    public void userValidatesTheDashboardData(String name, String description) {
        Assert.assertEquals(name, sharedData.getResponse().jsonPath().getString("name"));
        Assert.assertEquals(description, sharedData.getResponse().jsonPath().getString("description"));
    }

    @When("User deletes the dashboard with given dashboard Id {string}  under the Project {string}")
    public void userDeletesTheSpecifiedDashboard(String dashboardId, String projectName) throws IOException {
        sharedData.setResponse(sharedData.getServiceUtil().deleteResponseFromDeleteDashboard(
                fr.getPropertyValue("GetDashboard.Url"), projectName, dashboardId, fr.getPropertyValue("AuthorizationToken")));

    }

    @When("User adds the widget to the dashboardId {string} under the Project {string} with widget name {string} Id {string} and type {string}")
    public void userAddsTheWidgetToTheDashboard(String dashboardId, String projectName, String widgetName, String widgetId, String widgetType) throws IOException {
        sharedData.setWidgetSize(WidgetSize.builder().height(6).width(7).build());
        sharedData.setWidgetPosition(WidgetPosition.builder().positionX(0).positionY(0).build());
        sharedData.setWidgetOptions(WidgetOptions.builder().zoom(false).timeline("launch").viewMode("area-spline").build());
        sharedData.setAddWidget(AddWidget.builder().widgetId(Integer.parseInt(widgetId)).widgetName(widgetName).widgetType(widgetType).widgetOptions(sharedData.getWidgetOptions()).widgetPosition(sharedData.getWidgetPosition()).widgetSize(sharedData.getWidgetSize()).build());
        sharedData.setAddWidgetRequest(AddWidgetRequest.builder()
                .addWidget(sharedData.getAddWidget())
                .build());

        sharedData.setResponse(sharedData.getServiceUtil().putResponseFromAddWidgetToTheDashboard(
                sharedData.getAddWidgetRequest(), fr.getPropertyValue("PutDashboard.Url"), projectName, dashboardId, sharedData.getObjectMapper(), fr.getPropertyValue("AuthorizationToken")));
    }

    @When("User deletes the widget in the dashboardId {string} under the Project {string} with widget Id {string}")
    public void userAddsTheWidgetToTheDashboard(String dashboardId, String projectName, String widgetId) throws IOException {
        sharedData.setResponse(sharedData.getServiceUtil().deleteResponseFromDeleteWidgetInTheDashboard(
                fr.getPropertyValue("DeleteWidget.Url"), projectName, dashboardId, widgetId, fr.getPropertyValue("AuthorizationToken")));
    }
}

package utilities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ServiceUtil {


    public Response postResponseFromService(Object requestObject, String url, String projectName, ObjectMapper objectMapper, String token) throws JsonProcessingException {
        return RestAssured.given().log().all()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .pathParam("projectName", projectName)
                .body(objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL).writeValueAsString(requestObject))
                .when()
                .post(url)
                .then()
                .log().all()
                .contentType(ContentType.JSON)
                .extract().response();
    }

    public Response getResponseFromGetDashboard(String url, String projectName, String dashboardId, String token) throws JsonProcessingException {
        return RestAssured.given().log().all()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .pathParam("projectName", projectName)
                .pathParam("dashboardId", dashboardId)
                .when()
                .get(url)
                .then()
                .log().all()
                .contentType(ContentType.JSON)
                .extract().response();
    }

    public Response deleteResponseFromDeleteDashboard(String url, String projectName, String dashboardId, String token) throws JsonProcessingException {
        return RestAssured.given().log().all()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .pathParam("projectName", projectName)
                .pathParam("dashboardId", dashboardId)
                .when()
                .delete(url)
                .then()
                .log().all()
                .contentType(ContentType.JSON)
                .extract().response();
    }

    public Response putResponseFromAddWidgetToTheDashboard(Object requestObject, String url, String projectName, String dashboardId, ObjectMapper objectMapper, String token) throws JsonProcessingException {
        return RestAssured.given().log().all()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .pathParam("projectName", projectName)
                .pathParam("dashboardId", dashboardId)
                .body(objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL).writeValueAsString(requestObject))
                .when()
                .put(url)
                .then()
                .log().all()
                .contentType(ContentType.JSON)
                .extract().response();
    }

    public Response deleteResponseFromDeleteWidgetInTheDashboard(String url, String projectName, String dashboardId, String widgetId, String token) throws JsonProcessingException {
        return RestAssured.given().log().all()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .pathParam("projectName", projectName)
                .pathParam("dashboardId", dashboardId)
                .pathParam("widgetId", widgetId)
                .when()
                .delete(url)
                .then()
                .log().all()
                .contentType(ContentType.JSON)
                .extract().response();
    }
}

package utilities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.hc.core5.net.URIBuilder;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;

public class SlackService {


    private static final String SlackUrl="https://hooks.slack.com/services/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";
  ObjectMapper objectMapper = new ObjectMapper();
    public  void postNotification(Object requestObject) throws IOException {

        Response response =RestAssured.given().log().all()
                .header("Content-Type", "application/json")
                .body(objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL).writeValueAsString(requestObject))
                .when()
                .post(SlackUrl)
                .then()
                .log().all()
                .contentType(ContentType.HTML)
                .extract().response();
        System.out.println(response.getStatusCode());
    }

}

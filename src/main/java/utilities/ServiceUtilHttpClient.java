package utilities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.hc.core5.net.URIBuilder;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.asynchttpclient.Response;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class ServiceUtilHttpClient {
    public CloseableHttpResponse postResponseFromServiceUsingHttpClient(Object requestObject, String url, String projectName, ObjectMapper objectMapper, String token) throws URISyntaxException, IOException {

        HttpPost request = new HttpPost(url);
        request.addHeader(HttpHeaders.ACCEPT, "application/json");
        request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        request.addHeader(HttpHeaders.AUTHORIZATION, token);
        URI uri = new URIBuilder(request.getURI()).setParameter("projectName", projectName).build();
        request.setURI(uri);
        request.setEntity(new StringEntity(objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL).writeValueAsString(requestObject)));
        CloseableHttpClient client = HttpClientBuilder.create().build();
        CloseableHttpResponse response = client.execute(request);
        return response;
    }
}

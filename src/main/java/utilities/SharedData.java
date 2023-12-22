package utilities;

import api.requests.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.http.client.methods.CloseableHttpResponse;

@Data
@NoArgsConstructor
public class SharedData {

    private ServiceUtil serviceUtil = new ServiceUtil();
    private ServiceUtilHttpClient serviceUtilHttpClient = new ServiceUtilHttpClient();
    private ObjectMapper objectMapper = new ObjectMapper();
    private Response response;
    private CreateDashboardRequest createDashboardRequest;
    private AddWidgetRequest addWidgetRequest;
    private AddWidget addWidget;
    private WidgetOptions widgetOptions;
    private WidgetPosition widgetPosition;
    private WidgetSize widgetSize;
    private CloseableHttpResponse closeableHttpResponse;
    private SlackMessage slackMessage;
}

package api.requests;

import java.util.HashMap;
import java.util.Map;

public class RequestHeaders {

    public Map<String,String> getHeaders(String token){
        Map<String,String> headerMap= new HashMap<>();
        headerMap.put("accept", "application/json");
        headerMap.put("Content-Type", "application/json");
        headerMap.put("Authorization", token);

        return headerMap;

    }
}

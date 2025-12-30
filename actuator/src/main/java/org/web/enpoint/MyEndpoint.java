package org.web.enpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * @author czq
 * @date 2024/6/24 10:44
 * @Description:
 */
@Configuration
@Endpoint(id = "myEndpoint")
public class MyEndpoint {


    @ReadOperation
    public Map<String, Object> endpointByGet(@Selector String username, @Selector Integer age) {
        Map<String, Object> customMap = new HashMap<>();
        customMap.put("httpMethod", HttpMethod.GET.toString());
        customMap.put("username",username);
        customMap.put("age",age);
        return customMap;
    }



    @WriteOperation
    public Map<String, Object> endpointByPost(String username,Integer age) {
        Map<String, Object> customMap = new HashMap<>();
        customMap.put("httpMethod", HttpMethod.POST.toString());
        customMap.put("username",username);
        customMap.put("age",age);
        return customMap;
    }


}

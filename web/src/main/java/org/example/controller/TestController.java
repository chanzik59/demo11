package org.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author czq
 * @date 2024/8/22 16:42
 * @Description:
 */
@RequestMapping("test")
@Controller
public class TestController {


    @Value("${spring.test.msg}")
    private String msg;


    @Resource
    private AA aa;


    @RequestMapping("msg")
    @ResponseBody
    public String getMsg(HttpServletRequest request){
//        System.out.println("request:"+request);
//        Map<String, String> map = getMap(request);
//        String orderId = map.get("orderId");
        System.out.println(aa);
        return "aa";
    }


    private Map<String,String> getMap(String msg){
        Map<String, String> map = new HashMap<>();
        String[] split = msg.split("&");
        for (String s : split) {
            String[] split1 = s.split("=");
            map.put(split1[0],split1[1]);
        }
        return map;
    }









    


}

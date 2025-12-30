package org.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author czq
 * @date 2024/4/23 10:18
 * @Description:
 */
@RequestMapping("test")
@Controller
@RefreshScope
public class TestController {
    @Value("${bb}")
    private String bb;


    @ResponseBody
    @RequestMapping("cfg")
    public String cfg(){
        return bb;
    }
}

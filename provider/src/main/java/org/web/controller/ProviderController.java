package org.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author czq
 * @date 2024/4/23 15:38
 * @Description:
 */
@RequestMapping("test")
@Controller
public class ProviderController {

    @Resource
    private RestTemplate template;



    @ResponseBody
    @RequestMapping("tep")
    public String test(){
        String forObject = template.getForObject("http://test/test/cfg", String.class);
        return forObject;
    }



}

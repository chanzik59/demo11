package org.web;


import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.web.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * Unit test for simple App.
 */

@SpringBootTest
public class AppTest {


    @Resource
    private UserService userService;


    @Resource
    private RocketMQTemplate rocketMQTemplate;


    @Test
    public void test(){
        rocketMQTemplate.syncSend("aa","bb");
    }


}

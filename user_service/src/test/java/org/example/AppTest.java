package org.example;


import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.example.entity.User;
import org.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import javax.annotation.Resource;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

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

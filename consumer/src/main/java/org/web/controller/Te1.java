package org.web.controller;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.listener.Event;
import com.alibaba.nacos.api.naming.listener.EventListener;

import java.util.concurrent.TimeUnit;

/**
 * @author czq
 * @date 2024/4/23 14:52
 * @Description:
 */
public class Te1 {
    public static void main(String[] args) throws NacosException, InterruptedException {
        NamingService namingService = NamingFactory.createNamingService("localhost:8848");

        namingService.subscribe("api1", new EventListener() {
            @Override
            public void onEvent(Event event) {
                System.out.println(event);
            }
        });

        TimeUnit.DAYS.sleep(1);
    }
}

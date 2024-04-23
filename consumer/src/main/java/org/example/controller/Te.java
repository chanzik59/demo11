package org.example.controller;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;

import java.util.concurrent.TimeUnit;

/**
 * @author czq
 * @date 2024/4/23 14:52
 * @Description:
 */
public class Te {
    public static void main(String[] args) throws NacosException, InterruptedException {
        NamingService namingService = NamingFactory.createNamingService("localhost:8848");
        namingService.registerInstance("api1","192.168.0.1",8080);
        TimeUnit.DAYS.sleep(1);
    }
}

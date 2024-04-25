package org.example;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.example.service.FeignService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 */
@EnableFeignClients(clients = FeignService.class)
@MapperScan(basePackages = "org.example.mapper")
@SpringBootApplication
@EnableDubbo
public class UserApp {
    public static void main(String[] args) {
        SpringApplication.run(UserApp.class);
    }
}

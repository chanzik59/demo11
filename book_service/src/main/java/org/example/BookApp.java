package org.example;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 */
//@EnableDubbo
@MapperScan(basePackages = "org.example.mapper")
@SpringBootApplication
public class BookApp {
    public static void main(String[] args) {
        SpringApplication.run(BookApp.class);
    }
}

package org.web;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

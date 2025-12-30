package org.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
//@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr ="localhost:8848"))
//@NacosPropertySource(dataId = "test",autoRefreshed = true)
public class ConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class);
    }
}

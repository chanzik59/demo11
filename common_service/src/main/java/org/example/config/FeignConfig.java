package org.example.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author czq
 * @date 2024/4/25 10:14
 * @Description:
 */
public class FeignConfig {


    /**
     * 日志级别
     *
     * @return
     */
    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }
}

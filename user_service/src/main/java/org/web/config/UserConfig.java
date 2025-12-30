package org.web.config;

import com.alibaba.cloud.nacos.ribbon.NacosRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author czq
 * @date 2024/4/25 10:00
 * @Description:
 */
@Configuration
public class UserConfig {

    @Bean
    public IRule iRule(){
        return new NacosRule();
    }
}

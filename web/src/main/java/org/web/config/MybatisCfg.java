package org.web.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author czq
 * @date 2025/3/7 17:11
 * @Description:
 */
//@Configuration
public class MybatisCfg {

    @Bean
    public MybatisPlusInterceptor interceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
        paginationInnerInterceptor.setMaxLimit(20L);
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        return interceptor;
    }


    @Primary
    @Bean(name = "local")
    @ConfigurationProperties(prefix = "spring.datasource.local")
    public DataSource local() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "ucp")
    @ConfigurationProperties(prefix = "spring.datasource.ucp")
    public DataSource ucp() {
        return DataSourceBuilder.create().build();
    }

}

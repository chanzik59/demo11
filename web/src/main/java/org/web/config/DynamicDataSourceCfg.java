package org.web.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author czq
 * @date 2025/3/11 10:33
 * @Description:
 */
//@Configuration
public class DynamicDataSourceCfg {

    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource(@Qualifier("local") DataSource localDataSource,
                                        @Qualifier("ucp") DataSource ucpDataSource) {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("local", localDataSource);
        targetDataSources.put("ucp", ucpDataSource);
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(localDataSource);
        return dynamicDataSource;
    }

}

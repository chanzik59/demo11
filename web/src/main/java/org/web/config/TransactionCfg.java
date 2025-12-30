package org.web.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

/**
 * @author czq
 * @date 2025/3/11 10:23
 * @Description:
 */
//@Configuration
public class TransactionCfg {


    @Bean
    public DataSourceTransactionManager localManager(@Qualifier("local") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public DataSourceTransactionManager ucpManager(@Qualifier("ucp") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

}

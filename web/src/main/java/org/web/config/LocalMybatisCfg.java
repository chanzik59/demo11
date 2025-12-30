package org.web.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author czq
 * @date 2025/3/11 10:08
 * @Description:
 */
@MapperScan(basePackages = "org.web.mapper.local",sqlSessionFactoryRef = "localFactory")
//@Configuration
public class LocalMybatisCfg {

    @Bean
    public SqlSessionFactory localFactory(@Qualifier("local") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }


    @Bean
    public SqlSessionTemplate localTemplate(@Qualifier("localFactory") SqlSessionFactory factory) throws Exception {
        return new SqlSessionTemplate(factory);

    }
}

package com.june.springbootdemo.config;
import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@SpringBootConfiguration
@EnableTransactionManagement
public class DataSourceConfig {
    @Value("${spring.datasource.driver-class-name}")
    private String driverClass;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${login.authentication.provider}")
    private String authenticationType;
    @Value("${apikey.test.url}")
    private String apiKeyTestUrl;

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() throws PropertyVetoException {
        final ComboPooledDataSource datasource = new ComboPooledDataSource();
        datasource.setDriverClass(driverClass);
        datasource.setJdbcUrl(url);
        datasource.setUser(user);
        datasource.setPassword(password);
        return datasource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() throws PropertyVetoException {
        final DataSourceTransactionManager transManager = new DataSourceTransactionManager();
        transManager.setDataSource(dataSource());
        return transManager;
    }

    @Bean
    public String authenticationType() {
        return authenticationType;
    }

    @Bean
    public String apiKeyTestUrl() {
        return apiKeyTestUrl;
    }
}

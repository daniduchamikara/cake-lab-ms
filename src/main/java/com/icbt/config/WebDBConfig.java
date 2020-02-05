package com.icbt.config;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@PropertySource({ "classpath:cake-lab-ms-${spring.profiles.active}-db.properties" })
public class WebDBConfig {

    @Autowired
    private Environment env;

    @Bean(name = "cake-lab-ms-jdbc")
    public JdbcTemplate jdbcTemplate(@Qualifier("cake-lab-ms-datasource") DataSource dataSource) throws PropertyVetoException {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "cake-lab-ms-named-param-jdbc")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier("cake-lab-ms-datasource") DataSource dataSource) throws PropertyVetoException {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean(name = "cake-lab-ms-trasc-mgr")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("cake-lab-ms-datasource") DataSource dataSource) throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "cake-lab-ms-datasource")
    @Primary
    public DataSource ccbsDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(env.getProperty("cake.lab.ms.jdbc.driverClassName"));
        dataSource.setJdbcUrl(env.getProperty("cake.lab.ms.jdbc.url"));
        dataSource.setUsername(env.getProperty("cake.lab.ms.jdbc.user"));
        dataSource.setPassword(env.getProperty("cake.lab.ms.jdbc.pass"));
        dataSource.setMaximumPoolSize(Integer.parseInt(env.getProperty("cake.lab.ms.jdbc.connectionPool")));
        dataSource.addDataSourceProperty("oracle.jdbc.timezoneAsRegion","false");
        return dataSource;
    }

    @Bean
    @ConditionalOnMissingBean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Logger logger(InjectionPoint injectionPoint) {
        return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}

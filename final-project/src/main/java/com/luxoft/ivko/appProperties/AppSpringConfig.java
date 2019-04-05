package com.luxoft.ivko.appProperties;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.luxoft.ivko")
@PropertySource("classpath:application.properties")
public class AppSpringConfig {

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty(ConstantsContainer.PROPERTY_NAME_DATABASE_DRIVER));
        dataSource.setUrl(env.getRequiredProperty(ConstantsContainer.PROPERTY_NAME_DATABASE_URL));
        dataSource.setUsername(env.getRequiredProperty(ConstantsContainer.PROPERTY_NAME_DATABASE_USERNAME));
        dataSource.setPassword(env.getRequiredProperty(ConstantsContainer.PROPERTY_NAME_DATABASE_PASSWORD));
        return dataSource;
    }

    private Properties hibProperties() {
        Properties properties = new Properties();
        properties.put(ConstantsContainer.PROPERTY_NAME_HIBERNATE_DIALECT,
                env.getRequiredProperty(ConstantsContainer.PROPERTY_NAME_HIBERNATE_DIALECT));
        properties.put(ConstantsContainer.PROPERTY_NAME_HIBERNATE_SHOW_SQL,
                env.getRequiredProperty(ConstantsContainer.PROPERTY_NAME_HIBERNATE_SHOW_SQL));
        properties.put(ConstantsContainer.PROPERTY_NAME_HIBERNATE_DLL,
                env.getRequiredProperty(ConstantsContainer.PROPERTY_NAME_HIBERNATE_DLL));
        return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(
                env.getRequiredProperty(ConstantsContainer.PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
        entityManagerFactoryBean.setJpaProperties(hibProperties());
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
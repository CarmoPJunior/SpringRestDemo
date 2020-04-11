package com.example.SpringRestDemo.repository;

import javax.sql.DataSource;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@PropertySource({ "classpath:persistence-h2.properties" })
@EnableJpaRepositories(basePackages = "com.example.SpringRestDemo.repository", entityManagerFactoryRef="entityManagerFactory" ) 
//@EntityScan("com.example.SpringRestDemo.model")
@EnableTransactionManagement
public class PersistenceJPAConfig {
	
	@Autowired
	private Environment env;
	
	@Bean(name= "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    	
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] { "com.example.SpringRestDemo.model" });

        final JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
    }

    @Bean
    public DataSource dataSource() {
    	
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));

        return dataSource;
    }

    private Properties additionalProperties() {
    	
        Properties jpaProterties = new Properties();
		jpaProterties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		jpaProterties.put("hibernate.format_sql",true);
		jpaProterties.put("hibernate.show_sql", true);
		jpaProterties.put("hibernate.hbm2ddl.auto", "create");
            
        return jpaProterties;
    }        
    
//    @Bean(name="transactionManager")
//	public JpaTransactionManager transactionmanager(EntityManagerFactory emf){
//		
//		JpaTransactionManager transactionManager = new JpaTransactionManager();
//		transactionManager.setEntityManagerFactory( emf );
//		return transactionManager;
//		
//	}

}

package org.jsp.orderservice.util;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class SessionFactory {
	
	@Bean
	public LocalSessionFactoryBean localSessionFactory() {
		
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(getDataSource());
		factoryBean.setHibernateProperties(getProperties());
		factoryBean.setPackagesToScan("org.jsp.orderservice.entity");
		return factoryBean;
	}
	
	@Bean
	public DataSource getDataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/config_db");
		dataSource.setUsername("root");
		dataSource.setPassword("tiger");
		return dataSource;
	}
	
	public Properties getProperties() {
		
		Properties properties = new Properties();
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
}

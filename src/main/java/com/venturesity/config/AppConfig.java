package com.venturesity.config;

import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan( basePackages = "com.venturesity" )
@PropertySource( value = { "classpath:application.properties" } )
public class AppConfig {

	@Autowired
	private Environment environment;

	private static final Logger log = LoggerFactory.getLogger(AppConfig.class);

	public void configureDefaultServletHandling( DefaultServletHandlerConfigurer configurer )
	{
		configurer.enable();
	}

	@Bean
	public DataSource dataSource()
	{
		log.info("Register DataSource--> In progress");
		HikariConfig config = new HikariConfig();
		int poolSize = 20;
		config.setMaximumPoolSize(poolSize);
		config.setDataSourceClassName(environment.getRequiredProperty("spring.datasource.driver-class-name"));
		config.addDataSourceProperty("url", environment.getRequiredProperty("spring.datasource.url"));
		config.addDataSourceProperty("user", environment.getRequiredProperty("spring.datasource.username"));
		config.addDataSourceProperty("password", environment.getRequiredProperty("spring.datasource.password"));
		log.info("Register DataSource--> DONE");
		return new HikariDataSource(config);
	}
}
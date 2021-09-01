package com.productos.api.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceConfiguration {
	
	@Primary
	@Bean(name = "DataSourceFirst")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource firstDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Autowired
	@Bean(name = "Firstjdbc")
	public JdbcTemplate firstJdbcTemplate(@Qualifier("DataSourceFirst") DataSource dataSourceFirst) {
		return new JdbcTemplate(dataSourceFirst);
	}
}

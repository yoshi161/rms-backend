package com.mitrais.bootcamp.rms.config;

import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("runtime")
public class DBConfig {
	
	@Value("${spring.datasource.url}")
	String dataSourceUrl;
	
	@Value("${spring.datasource.username}")
	String username;
	
	@Value("${spring.datasource.password}")
	String password;
	
    @Bean
    public DataSource dataSource() throws URISyntaxException {

        System.out.println("dbUri: " + dataSourceUrl);

        System.out.println("username: " + username);

        System.out.println("password: " + password);
        
        return DataSourceBuilder
                .create()
                .username(username)
                .password(password)
                .url(dataSourceUrl)
                .build();
    }
}

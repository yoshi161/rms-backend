package com.mitrais.bootcamp.rms;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class RmsApplication {

	public static void main(String[] args) {
		Flyway flyway = new Flyway();
		flyway.setDataSource("jdbc:mysql://localhost:3306/rms", "root", "");
		flyway.migrate();
		SpringApplication.run(RmsApplication.class, args);
	}

}

package com.spring.pneu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,SecurityAutoConfiguration.class })
//@Configuration
//@ComponentScan(basePackages = "com.spring.pneu")

@SpringBootApplication

@EnableJpaRepositories("com.spring.pneu.Dao")

class PneuApplication {

	public static void main(String[] args) {
		SpringApplication.run(PneuApplication.class, args);
	}

}

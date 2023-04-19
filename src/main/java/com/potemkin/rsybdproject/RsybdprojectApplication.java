package com.potemkin.rsybdproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RsybdprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RsybdprojectApplication.class, args);
	}

}

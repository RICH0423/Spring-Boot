package com.rich.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = { "com.rich.microservice.config", "com.rich.microservice.resource",
				"com.rich.microservice.repository"} )
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

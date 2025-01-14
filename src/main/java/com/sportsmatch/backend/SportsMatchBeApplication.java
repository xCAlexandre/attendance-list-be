package com.sportsmatch.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.sportsmatch.backend.repositories")
public class SportsMatchBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsMatchBeApplication.class, args);
	}

}

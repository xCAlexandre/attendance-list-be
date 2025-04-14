package com.attendanceList.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.attendanceList.backend.repositories")
public class AttendanceListBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceListBeApplication.class, args);
	}

}

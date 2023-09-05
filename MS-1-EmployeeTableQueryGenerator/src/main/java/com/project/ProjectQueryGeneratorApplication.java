/*
Actual type of Project we work in here
Spring Boot with JDBC Used
RestAPI 
Without Repo: No initial declaration(for variables in heap memory)
MySQL Connected 
Postman URL: http://localhost:8080/employees
Unit Testing done with JUNIT
07 Aug 2023 
	#Enhancement to make dynamic CRUD Ops
	#Made dynamic selection of coloumn name in Select Query and passing table name from Postman.
08 Aug 2023
	#Made dynamic selection of ORDER BY and GROUP BY
09 Aug 2023
	#Implementation of Login Logout class.

*/
package com.project;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProjectQueryGeneratorApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectQueryGeneratorApplication.class, args);
	}
	@Bean
    RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}

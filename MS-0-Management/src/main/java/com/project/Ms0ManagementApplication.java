package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Ms0ManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms0ManagementApplication.class, args);
	}

    @Bean
    RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}

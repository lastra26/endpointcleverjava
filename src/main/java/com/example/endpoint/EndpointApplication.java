package com.example.endpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class EndpointApplication {

	public static void main(String[] args) {
		SpringApplication.run(EndpointApplication.class, args);
		System.out.println("Iniciando pruebaLocal endpoint App");
		System.out.println("Iniciando endpoint App");
	}

}

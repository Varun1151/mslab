package com.example.CitizenServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CitizenServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitizenServerApplication.class, args);
	}

}

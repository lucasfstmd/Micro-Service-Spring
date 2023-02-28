package com.microservice.getway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GetwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetwayApplication.class, args);
	}

}

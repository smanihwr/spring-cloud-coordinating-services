package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaTollRateBillboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaTollRateBillboardApplication.class, args);
	}
}

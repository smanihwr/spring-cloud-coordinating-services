package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.annotation.PreDestroy;

@EnableEurekaClient
@SpringBootApplication
public class EurekaFastpassServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaFastpassServiceApplication.class, args);
	}
}

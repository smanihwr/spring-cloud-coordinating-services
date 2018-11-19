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

//    @PreDestroy
//    public void onExit() {
//        System.out.println("###STOPing###");
//        try {
//            Thread.sleep(5 * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("###STOP FROM THE LIFECYCLE###");
//    }
}

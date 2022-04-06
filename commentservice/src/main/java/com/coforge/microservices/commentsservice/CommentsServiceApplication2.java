package com.coforge.microservices.commentsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class CommentsServiceApplication2 {

	public static void main(String[] args) {
		SpringApplication.run(CommentsServiceApplication2.class, args);
	}
	
	

}

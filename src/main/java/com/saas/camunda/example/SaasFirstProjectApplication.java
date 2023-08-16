package com.saas.camunda.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.camunda.zeebe.spring.client.EnableZeebeClient;

@SpringBootApplication
@EnableZeebeClient
public class SaasFirstProjectApplication{
	
	
	public static void main(String[] args) {
	SpringApplication.run(SaasFirstProjectApplication.class, args);
		System.out.println("Process Started...");
		
		
		
	}

}

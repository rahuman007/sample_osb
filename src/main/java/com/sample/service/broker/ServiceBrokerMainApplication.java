package com.sample.service.broker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class ServiceBrokerMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceBrokerMainApplication.class, args);
	}

	 @RequestMapping("hello")
	 public String sayHello(){
	        return ("Hello, SpringBoot on Wildfly");
	 }
}

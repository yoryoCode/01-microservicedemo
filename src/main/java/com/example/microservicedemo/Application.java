package com.example.microservicedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.example.microservicedemo.service.IEmployeesService;
import com.example.microservicedemo.service.impl.EmployeesServiceImpl; 

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * Used when run as WAR
	 * @param args
	 */
	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		
		return builder.sources(Application.class);
	}
	
	@Bean(name="employeesService")
	public IEmployeesService getEmployeesService() {
	    return new EmployeesServiceImpl(); 
	}
}

package com.example.microservicedemo.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.example.microservicedemo.controller.EmployeesController;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        registerEndpoints();
    }
    private void registerEndpoints() {
    	register(EmployeesController.class);
    }
}

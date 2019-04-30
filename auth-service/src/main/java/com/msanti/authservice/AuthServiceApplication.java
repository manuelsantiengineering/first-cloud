package com.msanti.authservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

// Enables the discovery client implementation to let our 
// authentication service register in Registry Service
@EnableDiscoveryClient
// Enables a Spring Security filter that authenticates requests via an incoming OAuth2 token
@EnableResourceServer
// Enables Spring Security global method security
@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

}

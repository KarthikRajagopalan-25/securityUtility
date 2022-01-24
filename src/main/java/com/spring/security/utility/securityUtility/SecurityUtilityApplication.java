package com.spring.security.utility.securityUtility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.spring.security.utility")
public class SecurityUtilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityUtilityApplication.class, args);
	}

}

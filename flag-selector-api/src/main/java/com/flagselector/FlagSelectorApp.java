package com.flagselector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication annotation, means this is the starting point for our
 *                        Spring Boot application
 * 
 * @SpringBootApplication enables many defaults. It is a convenience annotation
 *                        that
 *                        adds @Configuration, @EnableAutoConfiguration, @EnableWebMvc, @ComponentScan
 * 
 *                        TODO
 * @Configuration used to mark a configuration class that declares one or
 *                more @Bean methods and also triggers auto-configuration and
 *                component scanning.
 * @EnableAutoConfiguration
 * @EnableWebMvc
 * @ComponentScan
 * 
 * @author Neetu Malhotra
 *
 */
@SpringBootApplication
public class FlagSelectorApp {
	public static void main(String[] args) {
		SpringApplication.run(FlagSelectorApp.class, args);
	}

}

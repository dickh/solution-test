package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 
 * @author Kevin
 *
 */
@SpringBootApplication
@ServletComponentScan(basePackages = {"com.filter"})
public class SolutionTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolutionTestApplication.class, args);
	}
	
}

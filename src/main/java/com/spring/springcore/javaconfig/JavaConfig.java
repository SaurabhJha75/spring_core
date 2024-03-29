package com.spring.springcore.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

	@Bean
	public Student getStudent() {
		Student student = new Student(getSamosa());
		return student;
	}
	
	@Bean
	public Samosa getSamosa() {
		return new Samosa();
	}
}

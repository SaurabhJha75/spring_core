package com.spring.springcore.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
	
	AbstractApplicationContext context =  new ClassPathXmlApplicationContext("com/spring/springcore/lifecycle/config_lyfcycle.xml");
	
	 // Samosa s1 = (Samosa) context.getBean("s1");
	//  System.out.println(s1);
	
	//registering shutdown hook
	context.registerShutdownHook();
	
	System.out.println("++++++++++++++++++++++++++++");
	// Pepsi p1 = (Pepsi) context.getBean("p1");
	// System.out.println(p1);
	
	Chips c1 = (Chips) context.getBean("c1");
	System.out.println(c1);
	}

}

package com.spring.springcore.ci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("This testing for constructor injection");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/springcore/ci/config_ci.xml");
		Person p = (Person) context.getBean("person");
		Addition add = (Addition) context.getBean("add");
		
		System.out.println(p);
		add.doSum();
	}

}

package com.spring.springcore.auto.wire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/springcore/auto/wire/auto_config.xml");
		Emp emp1 = (Emp) context.getBean("emp1", Emp.class);
		System.out.println(emp1);
	}

}

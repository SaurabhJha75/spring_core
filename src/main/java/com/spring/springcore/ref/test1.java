package com.spring.springcore.ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("This is for the reference type");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/springcore/ref/config2.xml");
		A a = (A) context.getBean("aref");
		
		System.out.println(a.getX());
		System.out.println(a.getOb().getY());
		System.out.println(a);
	}

}

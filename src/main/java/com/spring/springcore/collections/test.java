package com.spring.springcore.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcom to Spring core Project");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/springcore/collections/config1.xml");
		Emp emp = (Emp) context.getBean("emp");
		
		System.out.println("Name: "+emp.getName());
		System.out.println("Phone Numbers: "+emp.getPhones());
		System.out.println("Addresses: "+emp.getAddresses());
		System.out.println("Courses: "+emp.getCourses());
		System.out.println(emp.getPhones().getClass().getName());
		
	}

}

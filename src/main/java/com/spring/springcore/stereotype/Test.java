package com.spring.springcore.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/springcore/stereotype/stereotype_config.xml");
		Student student = context.getBean("ob", Student.class);
		System.out.println(student);
		
		System.out.println(student.getAddress());
		System.out.println(student.getAddress().getClass().getName());
		System.out.println(student.hashCode());
		
		Student student2 = context.getBean("ob", Student.class);
		System.out.println(student2.hashCode());
		
		Teacher t1 = context.getBean("teacher1", Teacher.class);
		Teacher t2 = context.getBean("teacher1", Teacher.class);
		
		System.out.println(t1.hashCode());
		System.out.println(t2.hashCode());
	}

}

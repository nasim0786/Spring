package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		Coach coach = context.getBean("myCoach", Coach.class);
		
		Coach coach1 = context.getBean("myCoach", Coach.class);
		
		boolean result = coach == coach1;
		System.out.println("pointing to the same object: " + result);
		System.out.println("Memory location of the coach: " + coach);
		System.out.println("Memory location of the coach1: " + coach1);

	}

}

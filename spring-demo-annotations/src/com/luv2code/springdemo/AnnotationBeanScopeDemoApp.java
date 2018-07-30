package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach coach = context.getBean("tennisCoach", Coach.class);
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		boolean result = (coach == theCoach); 
		
		System.out.println("Pointing to the same object: " + result);
		
		System.out.println("Memory Allocation of coach:" + coach);
		
		System.out.println("Memory Allocation of theCoach: " + theCoach);
		
		context.close();

	}

}

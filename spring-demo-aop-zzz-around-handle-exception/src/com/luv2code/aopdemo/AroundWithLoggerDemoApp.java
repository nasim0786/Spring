package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
	
	private static Logger logger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService trafficFortuneSvc = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		logger.info(("Main Program: AroundDemoApp"));
		
		logger.info("Calling getFortune()");
		
		String data = trafficFortuneSvc.getFortune();
		
		logger.info("My fortune is: " + data);
		
		logger.info("finished");
		
		context.close();

	}

}

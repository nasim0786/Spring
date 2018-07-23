package com.luv2code.springdemo;

public class HappyFortuneService implements FortuneService {
	
	public HappyFortuneService() {
		System.out.println("HappyFortuneService: inside no-arg constructor.");
	}

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}

}

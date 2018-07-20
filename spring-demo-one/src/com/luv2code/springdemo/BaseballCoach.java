package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	private FortuneService fortuneService;
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}
	
	public BaseballCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}
	

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

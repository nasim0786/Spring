package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {
/*	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;*/
	
	private FortuneService fortuneService;

    // define a default constructor
    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }
    
    @PostConstruct
    public void doMyStartupStuff() {
    	System.out.println(">> TennisCoach: inside of doMyStartupStuff");
    }
    
    @PreDestroy
    public void doMyCleanupStuff() {
    	System.out.println(">> TennisCoach: inside of doMyStartupStuff");
    }
    
    /*
     @Qualifier is a nice feature, but it is tricky when used with Constructors.
	 The syntax is much different from other examples and not exactly intuitive.  Consider this the "deep end of the pool" when it comes to Spring configuration LOL :-)
	 You have to place the @Qualifier annotation inside of the constructor arguments. 
     */
    
    @Autowired
    public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {

        System.out.println(">> TennisCoach: inside constructor using @autowired and @qualifier");
        
        fortuneService = theFortuneService;
    }
	
	/*@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}*/


	/*
	@Autowired
	public void doSomeCrazyStuff(FortuneService theFortuneService) {
		System.out.println("TennisCoach: inside setFortuneService");
		fortuneService = theFortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

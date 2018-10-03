package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	public String getFortune() {
		try {
			TimeUnit.SECONDS.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "Expect Heavy Traffic this Morning.";
	}

}

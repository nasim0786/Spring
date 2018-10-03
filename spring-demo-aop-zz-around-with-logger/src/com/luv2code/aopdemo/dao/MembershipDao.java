package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {
	
	public boolean addAccount() {
		System.out.println(getClass() + ": Adding a membership account.");
		
		return true;
	}
	
	public void doWork() {
		System.out.println(getClass() + ": doing work related to membership .");
	}

}

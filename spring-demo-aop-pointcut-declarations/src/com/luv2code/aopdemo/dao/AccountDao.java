package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDao {
	public void addAccount(Account account) {
		System.out.println(getClass() + ": Doing my DB work.");
	}
	
	public boolean doWork(Account account) {
		System.out.println(getClass() + ": Doing my work.");
		return false;
	}

}

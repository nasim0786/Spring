package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {
	public void addAccount() {
		System.out.println(getClass() + ": Doing my DB work.");
	}

}

package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDao {
	private String name;
	
	private String serviceCode;
	
	public List<Account> findAccounts() {
		List<Account> accounts = new ArrayList<>();
		
		Account account1 = new Account("Md", "Silver");
		Account account2 = new Account("Nasim", "Gold");
		Account account3 = new Account("Md Nasim", "Platinum");
		
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		
		return accounts;
	}
	
	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account account) {
		System.out.println(getClass() + ": Doing my DB work.");
	}
	
	public boolean doWork(Account account) {
		System.out.println(getClass() + ": Doing my work.");
		return false;
	}

}

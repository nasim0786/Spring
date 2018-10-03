package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDao;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
		
		List<Account> accounts = null;
		
		try {
			boolean tripWire = true;
			accounts = accountDao.findAccounts(tripWire);
		} catch(Exception e) {
			System.out.println("Main Program caught Exception." + e);
		}
		
		System.out.println("After Throwing Demo App: ");
		
		System.out.println("--------");
		System.out.println(accounts);
		System.out.println("--------\n");
		
		context.close();

	}

}

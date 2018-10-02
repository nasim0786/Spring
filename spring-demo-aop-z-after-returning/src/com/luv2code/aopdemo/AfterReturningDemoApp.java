package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDao;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
		
		List<Account> accounts = accountDao.findAccounts();
		
		System.out.println("After Returning Demo App: ");
		
		System.out.println("--------");
		System.out.println(accounts);
		System.out.println("--------\n");
		
		context.close();

	}

}

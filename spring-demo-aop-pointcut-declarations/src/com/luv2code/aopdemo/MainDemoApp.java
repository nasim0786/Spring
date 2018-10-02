package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDao;
import com.luv2code.aopdemo.dao.MembershipDao;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
		
		MembershipDao membershipDao = context.getBean("membershipDao", MembershipDao.class);
		
		Account account = new Account();
		accountDao.addAccount(account);
		accountDao.doWork(account);
		
		membershipDao.addAccount();
		membershipDao.doWork();
		
		context.close();

	}

}

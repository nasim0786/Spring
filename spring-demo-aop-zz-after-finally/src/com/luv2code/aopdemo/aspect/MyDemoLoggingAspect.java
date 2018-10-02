package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDao.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPint) {
		String method = joinPint.getSignature().toShortString();
		System.out.println("======> Executing @After (finally) on method: " + method);
	}
	
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDao.findAccounts(..))",
			throwing="exc")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPint, Throwable exc) {
		
		String method = joinPint.getSignature().toShortString();
		
		System.out.println("======> Executing @AfterThrowing on method: " + method);
		
		System.out.println("======> Exception is: " + exc);
	}
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDao.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPint, List<Account> result) {
		String method = joinPint.getSignature().toShortString();
		
		System.out.println("===> Executing @AfterReturning on method: " + method);
		
		System.out.println("======> Result is: " + result);
		
		convertAccountNamesToUpperCase(result);
		
		System.out.println("======> Result is: " + result);
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account account : result) {
			String upperName = account.getName().toUpperCase();
			account.setName(upperName);
		}
		
	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n ========>>> Executing @Before advice on method");
		
		MethodSignature mSign = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("Method: " + mSign);
		
		Object[] objects = joinPoint.getArgs();
		
		for (Object obj : objects) {
			System.out.println(obj);
			
			if (obj instanceof Account) {
				Account account = (Account) obj;
				
				System.out.println("Account Name: " + account.getName());
				System.out.println("Account Level: " + account.getLevel());
			}
		}
	}
	
}

package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String method = proceedingJoinPoint.getSignature().toShortString();
		logger.info("======> Executing @Around on method: " + method);
		
		long begin = System.currentTimeMillis();
		
		Object result = null;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Exception e) {
			logger.warning(e.getMessage());
			
			throw e;
			//result = "Got Exception here in aroundGetFortune()";
		}
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		
		logger.info("=======> Duration: " + duration / 1000.0 + "seconds");
		return result;
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDao.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPint) {
		String method = joinPint.getSignature().toShortString();
		logger.info("======> Executing @After (finally) on method: " + method);
	}
	
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDao.findAccounts(..))",
			throwing="exc")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPint, Throwable exc) {
		
		String method = joinPint.getSignature().toShortString();
		
		logger.info("======> Executing @AfterThrowing on method: " + method);
		
		logger.info("======> Exception is: " + exc);
	}
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDao.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPint, List<Account> result) {
		String method = joinPint.getSignature().toShortString();
		
		logger.info("===> Executing @AfterReturning on method: " + method);
		
		logger.info("======> Result is: " + result);
		
		convertAccountNamesToUpperCase(result);
		
		logger.info("======> Result is: " + result);
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account account : result) {
			String upperName = account.getName().toUpperCase();
			account.setName(upperName);
		}
		
	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		logger.info("\n ========>>> Executing @Before advice on method");
		
		MethodSignature mSign = (MethodSignature) joinPoint.getSignature();
		
		logger.info("Method: " + mSign);
		
		Object[] objects = joinPoint.getArgs();
		
		for (Object obj : objects) {
			logger.info(obj.toString());
			
			if (obj instanceof Account) {
				Account account = (Account) obj;
				
				logger.info("Account Name: " + account.getName());
				logger.info("Account Level: " + account.getLevel());
			}
		}
	}
	
}

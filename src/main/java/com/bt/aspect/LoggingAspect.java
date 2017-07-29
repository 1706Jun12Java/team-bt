package com.bt.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static Logger log = Logger.getRootLogger();
			
	@AfterThrowing(pointcut="within(com.bt.dao.*)")
	public void logAfterThrow(JoinPoint jp){
		log.error(jp.getThis().toString());
		
	}
	
	@AfterReturning(pointcut="within(com.revature.dao.*)")
	public void logAfter(JoinPoint jp){
		log.info(jp.getThis().toString());
	}
	
}
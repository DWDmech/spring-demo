package org.home.core;

import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectLogger {
	
	private Map<Class<?>, Integer> counter;
	
	@AfterReturning("allLog()")
	public void count(JoinPoint jp) {
		Class<?> clazz = jp.getTarget().getClass();
		if(!counter.containsKey(clazz)) {
			counter.put(clazz, 0);
		}
		counter.put(clazz, counter.get(clazz)+1);
	}
	
	@Pointcut("execution(* *.logEvent(..))")
	public void allLog(){
		System.out.println("pointcut");
	}
	
	@Before("allLog()")
	public void lgoBefore(JoinPoint j){
		System.out.println(j.getTarget().getClass().getName() + " " + j.getSignature().getName());
	}
	
	@AfterReturning(pointcut="allLog()", returning="retVal")
	public void LogAfter(Object retVal){
		System.out.println("After");
		System.out.println("RetVal: " + retVal);
	}
	
}

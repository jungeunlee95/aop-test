package com.cafe24.aoptest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	@Before("execution(ProductVo com.cafe24.aoptest.ProductService.find(String))")
	public void beforeAdvice() {
		System.out.println("--- @Before advice ---");
	} 
	
	@After("execution(* *..*.ProductService.*(..))") 
	public void afterAdvice() {
		System.out.println("--- @After advice ---");
	} 
	
	@AfterReturning("execution(* *..*.ProductService.*(..))") 
	public void afterReturningAdvice() {
		System.out.println("--- @AfterReturning advice ---");
	} 
	
	@AfterThrowing(value="execution(* *..*.ProductService.*(..))", throwing="ex") 
	public void afterThrowingAdvice(Throwable ex) {
		System.out.println("--- @AfterThrowing advice ---");
	} 
	
	@Around(value="execution(* *..*.ProductService.*(..))")
	public Object roundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		// before advice
		System.out.println("--- @Around(before) advice ---");
		
		// Point Cut 되는 메소드 호출
		Object[] parameters = {"Camera"};
		Object result = pjp.proceed(parameters);
//		Object result = pjp.proceed();
		
		// after advice
		System.out.println("--- @Around(after) advice ---");
		
		return result;
	}
	 

} 












package com.chudichen.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author chudichen
 * @date 2021-06-16
 */
@Aspect
@Component
@EnableAspectJAutoProxy
public class AspectDefinition {

	@Pointcut("execution(* com.chudichen.spring.aop.*.getTestStr(..))")
	public void pointcut() {
	}

	@Around("pointcut()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("Execute aop method");
		return proceedingJoinPoint.proceed();
	}
}

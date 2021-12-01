package com.spring.aop.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @Around("execution(* com.spring.aop..*.DevelopService.*(..))")
    public Object printLogAroundAtClass(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println(String.format("%s-printLogAroundAtClass", System.currentTimeMillis()));
        return proceedingJoinPoint.proceed();
    }

    @AfterReturning(value = "bean(backendServiceImpl)", returning = "returnValue")
    public void printLogAfterReturningAtBean(JoinPoint joinPoint, Object returnValue) throws Throwable{
        System.out.println(String.format("%s-%s-printLogAfterThrowingAtBean", returnValue, System.currentTimeMillis()));
    }

    @AfterThrowing(value = "bean(frontendServiceImpl)", throwing = "exception")
    public void printLogAfterThrowingAtBean(JoinPoint joinPoint, Exception exception) throws Throwable{
        System.out.println(String.format("%s-%s-printLogAfterThrowingAtBean", exception.getMessage(), System.currentTimeMillis()));
    }

    @Before("@annotation(CustomLog)")
    public void printLogBeforeAtAnnotation(JoinPoint joinPoint) throws Throwable{
        System.out.println(String.format("%s-printLogBeforeAtAnnotation", System.currentTimeMillis()));
    }
}

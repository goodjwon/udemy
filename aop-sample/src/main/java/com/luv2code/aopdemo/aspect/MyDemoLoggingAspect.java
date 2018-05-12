package com.luv2code.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(public * com.luv2code.aopdemo.dao.*.*(..))")
    private void forDapPackage(){};

    @Before("forDapPackage()")
    public void beforeAddAccountAdivce() {
        System.out.println("\n====>>>> Executing @Before advice on addAccount()");
    }
}

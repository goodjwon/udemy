package com.luv2code.aopdemo.aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDapPackageNoGetterAndSetter()")
    public void beforeAddAccountAdivce() {
        System.out.println("\n====>>>> Executing @Before advice on addAccount()");
    }

}

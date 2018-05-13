package com.luv2code.aopdemo.aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(public * com.luv2code.aopdemo.dao.*.*(..))")
    private void forDapPackage(){};

    @Pointcut("execution(public * com.luv2code.aopdemo.dao.*.get*(..))")
    private void getter(){};

    @Pointcut("execution(public * com.luv2code.aopdemo.dao.*.set*(..))")
    private void setter(){};

    @Pointcut("forDapPackage() && !(getter() || setter())")
    private void forDapPackageNoGetterAndSetter(){};





    @Before("forDapPackageNoGetterAndSetter()")
    public void beforeAddAccountAdivce() {
        System.out.println("\n====>>>> Executing @Before advice on addAccount()");
    }

    @After("forDapPackageNoGetterAndSetter()")
    public void perFormApiUse() {
        System.out.println("\n====>>>> Perform reuse API Call");
    }

//    @Before("getter()")
//    public void beforeGettertAdivce() {
//        System.out.println("\n====>>>> Executing @Before advice on getter()");
//    }
//
//    @Before("setter()")
//    public void beforeSetterAdivce() {
//        System.out.println("\n====>>>> Executing @Before advice on setter()");
//    }

}

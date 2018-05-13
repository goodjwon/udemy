package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

    @Pointcut("execution(public * com.luv2code.aopdemo.dao.*.*(..))")
    public void forDapPackage(){};

    @Pointcut("execution(public * com.luv2code.aopdemo.dao.*.get*(..))")
    public void getter(){};

    @Pointcut("execution(public * com.luv2code.aopdemo.dao.*.set*(..))")
    public void setter(){};

    @Pointcut("forDapPackage() && !(getter() || setter())")
    public void forDapPackageNoGetterAndSetter(){};

}

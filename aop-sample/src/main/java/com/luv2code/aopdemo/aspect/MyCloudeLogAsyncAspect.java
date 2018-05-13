package com.luv2code.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyCloudeLogAsyncAspect {

    @Before("forDapPackageNoGetterAndSetter()")
    public void logToCloudeAsync() {
        System.out.println("\n====>>>> Logging to cloud in async fashion");
    }
}

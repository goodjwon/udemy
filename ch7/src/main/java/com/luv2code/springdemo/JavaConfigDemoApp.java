package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

    public static void main(String[] args) {

        // read Spring Config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        Coach tennisCoach =  context.getBean("tennisCoach", TennisCoach.class);

        System.out.println(tennisCoach.getDeilyWorkOut());

        System.out.println(tennisCoach.getDeilyFortune());

        // close the context
        context.close();

    }
}

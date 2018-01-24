package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemo {

    public static void main(String[] args) {

        // read Spring Config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach tennisCoach =  context.getBean("tennisCoach", TennisCoach.class);

        System.out.println(tennisCoach.getDeilyWorkOut());

        // close the context
        context.close();

    }
}

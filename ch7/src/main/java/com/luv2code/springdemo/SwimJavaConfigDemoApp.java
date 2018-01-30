package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args) {

        // read Spring Config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        Coach tennisCoach =  context.getBean("swimCoach", SwimCoach.class);

        System.out.println(tennisCoach.getDeilyWorkOut());

        System.out.println(tennisCoach.getDeilyFortune());

        // close the context
        context.close();

    }
}

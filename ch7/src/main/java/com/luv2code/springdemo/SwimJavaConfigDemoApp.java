package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args) {

        // read Spring Config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        SwimCoach swimCoach =  context.getBean("swimCoach", SwimCoach.class);

        System.out.println(swimCoach.getDeilyWorkOut());

        System.out.println(swimCoach.getDeilyFortune());

        // call our new swim coach methods ... has the props values injected
        System.out.println("email is "+swimCoach.getEmail());
        System.out.println("team is "+swimCoach.getTeam());

        // close the context
        context.close();

    }
}

package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

    public static void main(String[] args) {
        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        Coach trackCoachCoach = context.getBean("myTrackCoach", Coach.class);

        System.out.println("=========myCoach========");
        // call methods on the bean
        System.out.println(theCoach.getDailyWorkout());

        //let's call our new method for fortunes
        System.out.println(theCoach.getDailyFortune());

        System.out.println("=========myTrackCoach========");

        // call methods on the bean
        System.out.println(trackCoachCoach.getDailyWorkout());

        //let's call our new method for fortunes
        System.out.println(trackCoachCoach.getDailyFortune());


        // close the context
        context.close();
    }
}

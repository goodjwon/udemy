package com.luv2code.springdemo;


public class MyApp {

    public static void main(String[] args) {

        // create the Object
        Coach theCoach = new TrackCoach();

        //Use the Object
        System.out.println(theCoach.getDailyWorkout());

    }
}

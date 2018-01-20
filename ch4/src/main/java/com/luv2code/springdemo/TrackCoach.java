package com.luv2code.springdemo;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public TrackCoach() {

    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just Do it: "+fortuneService.getFortune();
    }


    public void doMyStartupStuff(){
        System.out.println("Track Coach: inside method doMyStartupStuff");
    }

    public void doMyCleanupStuff(){
        System.out.println("Track Cooch: inside method doMyCleanupStuffYoYo");
    }
}

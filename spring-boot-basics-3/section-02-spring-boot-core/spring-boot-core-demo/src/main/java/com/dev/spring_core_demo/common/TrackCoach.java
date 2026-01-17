package com.dev.spring_core_demo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    public TrackCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public Integer getCoachId() {
        return 0;
    }

    @Override
    public String getDailyWorkout() {
        return "TrackCoach, run hard on track for 5k!";
    }
}

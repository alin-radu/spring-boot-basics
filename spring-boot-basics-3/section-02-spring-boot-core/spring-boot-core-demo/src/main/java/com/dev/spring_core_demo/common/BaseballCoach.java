package com.dev.spring_core_demo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    public BaseballCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public Integer getCoachId() {
        return 0;
    }

    @Override
    public String getDailyWorkout() {
        return "BaseballCoach, spend 30min in batting practice!";
    }
}

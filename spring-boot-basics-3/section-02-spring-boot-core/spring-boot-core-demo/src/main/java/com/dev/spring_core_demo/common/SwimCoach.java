package com.dev.spring_core_demo.common;

import org.springframework.context.annotation.Lazy;

@Lazy
public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public Integer getCoachId() {
        return 0;
    }
    @Override
    public String getDailyWorkout() {
        return "SwimCoach, swim 1000 meters as a warm up.";
    }
}

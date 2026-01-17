package com.dev.spring_core_demo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CricketCoach implements Coach {

    private static int counter = 1;
    private int coachId = 0;

    public CricketCoach() {
        coachId = counter;
        counter++;
        System.out.println("In constructor: " + getClass().getSimpleName() + " the counter value: " + coachId);
    }

    @PostConstruct
    public void doStuffOnInit() {
        System.out.println("In doStuffOnInit: " + getClass().getSimpleName());
    }

    @PreDestroy
    public void doStuffOnDestroy() {
        System.out.println("In doStuffOnDestroy: " + getClass().getSimpleName());
    }

    @Override
    public Integer getCoachId() {
        return coachId;
    }

    @Override
    public String getDailyWorkout() {
        return "CricketCoach, practice fast bowling for 15 minutes!";
    }
}

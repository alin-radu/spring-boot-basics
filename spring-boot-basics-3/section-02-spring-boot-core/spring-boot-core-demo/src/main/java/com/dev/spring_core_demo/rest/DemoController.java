package com.dev.spring_core_demo.rest;

import com.dev.spring_core_demo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daily-workout")
public class DemoController {

    private final Coach coach;
    private Coach secondCoach;

//    @Autowired
//    public DemoController(Coach coach) {
//        this.coach = coach;
//    }

//    @Autowired
//    public DemoController(@Qualifier("cricketCoach") Coach coach,
//                          @Qualifier("cricketCoach") Coach secondCoach) {
//        System.out.println("In constructor: " + getClass().getSimpleName());
//
//        this.coach = coach;
//        this.secondCoach = secondCoach;
//    }

    @Autowired
    public DemoController(@Qualifier("swimCoach") Coach coach) {
        System.out.println("In constructor: " + getClass().getSimpleName());

        this.coach = coach;
    }

//    @Autowired
//    public void setCoach(Coach coach) {
//        this.coach = coach;
//    }

//    @Autowired
//    public void doSomePreparation(Coach coach) {
//        System.out.println("executed");
//        this.coach = coach;
//    }

    @GetMapping("")
    public String getDailyWorkout() {

        if (secondCoach != null) {
            return coach.getDailyWorkout() + ", the coachId is: " + coach.getCoachId() +
                    "<br>" +
                    secondCoach.getDailyWorkout() + ", the coachId is: " + secondCoach.getCoachId();
        } else {
            return coach.getDailyWorkout();
        }
    }
}

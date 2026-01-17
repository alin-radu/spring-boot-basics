package com.dev.springBootOverview.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a Hard 5k.";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day.";
    }

    @GetMapping("/team-info")
    public String getTeamInfo() {
        return """
                <h3>Coach Name:</h3>
                <p><b>${coachName}</b></p>
                <h3>Team Name:</h3>
                <p><b>${teamName}</b></p>
                """
                .replace("${coachName}", coachName)
                .replace("${teamName}", teamName);
    }

}

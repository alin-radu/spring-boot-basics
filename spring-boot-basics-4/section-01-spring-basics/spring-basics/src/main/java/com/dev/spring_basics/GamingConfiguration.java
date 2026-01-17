package com.dev.spring_basics;

import com.dev.spring_basics.game.GameRunner;
import com.dev.spring_basics.game.GamingConsole;
import com.dev.spring_basics.game.PacmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GameRunner gameRunner(GamingConsole game) {
        return new GameRunner(game);
    }

    @Bean
    public GamingConsole game() {
        return new PacmanGame();
    }

}

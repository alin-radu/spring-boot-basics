package com.dev.spring_basics_2.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    private final GamingConsole game;


    public GameRunner(@Qualifier("marioGame") GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running game: " + game.getClass().getSimpleName());
        game.up();
        game.down();
        game.left();
        game.right();
    }
}

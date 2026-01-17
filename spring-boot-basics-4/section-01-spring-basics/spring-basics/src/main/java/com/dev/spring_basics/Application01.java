package com.dev.spring_basics;

import com.dev.spring_basics.game.GameRunner;
import com.dev.spring_basics.game.PacmanGame;

public class Application01 {

    public static void main(String[] args) {
//        var game = new MarioGame();
//        var game = new SuperContraGame();

        // 1. object creation;
        var game = new PacmanGame();

        // 2. object creation + wiring dependencies;
        // game is a dependency of GameRunner;
        var gameRunner = new GameRunner(game);

        gameRunner.run();
    }

}

package com.dev.spring_basics_2.game;

import org.springframework.stereotype.Component;

@Component
//@Qualifier("SuperContraGameQualifier")
public class SuperContraGame implements GamingConsole {
    public void up() {
        System.out.println("Up");
    }

    public void down() {
        System.out.println("Sit down");
    }
    public void left() {
        System.out.println("Go back");
    }
    public void right() {
        System.out.println("Shoot a bullet");
    }
}

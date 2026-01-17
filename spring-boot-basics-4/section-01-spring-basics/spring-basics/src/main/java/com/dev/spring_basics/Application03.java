package com.dev.spring_basics;

import com.dev.spring_basics.game.GameRunner;
import com.dev.spring_basics.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application03 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(GamingConfiguration.class);

        context.getBean(GamingConsole.class).up();

        context.getBean(GameRunner.class).run();
    }

}

package com.dev.spring_basics_2.game;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
//@ComponentScan("com.dev.spring_basics_2")
public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);

        context.getBean("marioGame", GamingConsole.class).up();

        context.getBean(GameRunner.class).run();
    }

}



package com.dev.spring_basics_2.learning.a0;

import com.dev.spring_basics_2.utils.Helpers;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@ComponentScan("com.dev.spring_basics_2.learning.a0")
public class Application {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(Application.class);

        Helpers.printContextBeans(context);

        System.out.println("Application | Initialization of context completed.");
    }
}

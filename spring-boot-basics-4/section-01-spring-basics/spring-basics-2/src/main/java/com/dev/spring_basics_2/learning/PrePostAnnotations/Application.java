package com.dev.spring_basics_2.learning.PrePostAnnotations;

import com.dev.spring_basics_2.utils.Helpers;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
class SomeClass {

    private final SomeDependency someDependency;

    SomeClass(SomeDependency someDependency) {
        this.someDependency = someDependency;

        System.out.println("SomeClass | constructor | All dependencies are ready.");
    }

    @PostConstruct
    public void initialize (){
        someDependency.getReady();
    }

    @PreDestroy
    public void cleanup(){
        System.out.println("SomeClass | cleanup | Cleanup.");
    }
}

@Component
class SomeDependency {

    public void getReady() {
        System.out.println("SomeDependency | getReady | Some logic executed.");
    }
}

//@SpringBootApplication
@ComponentScan("com.dev.spring_basics_2.learning.PrePostAnnotations")
public class Application {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(Application.class);

        Helpers.printContextBeans(context);

        System.out.println("Application | Initialization of context completed.");
    }
}

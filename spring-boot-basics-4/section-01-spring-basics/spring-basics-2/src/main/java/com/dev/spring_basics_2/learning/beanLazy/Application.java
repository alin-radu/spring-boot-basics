package com.dev.spring_basics_2.learning.beanLazy;

import com.dev.spring_basics_2.utils.Helpers;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
class ClassA {

}

@Component
//@Lazy
class ClassB {
    private final ClassA classA;

    ClassB(ClassA classA) {
        System.out.println("ClassB | constructor | Some initialization logic goes here.");
        this.classA = classA;
    }

    public void doSomething() {
        System.out.println("ClassB | doSomething | Do something.");
    }
}

//@SpringBootApplication
@ComponentScan("com.dev.spring_basics_2.learning.beanLazy")
public class Application {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(Application.class);

        Helpers.printContextBeans(context);

        System.out.println("Application | Initialization of context completed.");

        context.getBean(ClassB.class).doSomething();
    }
}

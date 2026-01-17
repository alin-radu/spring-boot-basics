package com.dev.spring_basics_2.learning.beanScopes;

import com.dev.spring_basics_2.utils.Helpers;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component
class NormalClass {

}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {

}

//@SpringBootApplication
@ComponentScan("com.dev.spring_basics_2.learning.beanScopes")
public class Application {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(Application.class);

        Helpers.printContextBeans(context);

        System.out.println("Application | Initialization of context completed.");

    }
}

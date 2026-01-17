package com.dev.spring_basics.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Application02 {

    public static void main(String[] args) {
        // 1. launch a Spring Context;
        try (var context = new AnnotationConfigApplicationContext(Application02Configuration.class)) {
            // 2. configure things that we want Spring to manage -> @Configuration;

            // 3. retrieving beans managed by Spring;
//        System.out.println(context.getBean("name"));
//
//        System.out.println(context.getBean("age"));
//
//        System.out.println(context.getBean("person"));

//        System.out.println(context.getBean("customAddress"));

//        System.out.println(context.getBean("person2MethodCall"));
//
//        System.out.println(context.getBean("person3Parameters"));

//        System.out.println(context.getBean("customAddress"));
//
//        System.out.println(context.getBean(Address.class));

            Arrays
                    .stream(context.getBeanDefinitionNames())
                    .forEach(b -> System.out.println("---> " + b));

            System.out.println(context.getBeanDefinitionCount());
        }

    }

}

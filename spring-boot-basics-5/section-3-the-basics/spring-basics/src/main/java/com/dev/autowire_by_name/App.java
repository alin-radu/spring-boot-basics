package com.dev.autowire_by_name;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationAutowireByName.xml");

        Car car = (Car) context.getBean("myCar");

        car.displayDetails();
    }
}

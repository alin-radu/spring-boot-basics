package com.dev.bean_example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // load the Spring Context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationBeanContext.xml");

        // get the bean from the Context
        MyBean myBean = (MyBean) context.getBean("myBean");

        System.out.println(myBean);
    }
}

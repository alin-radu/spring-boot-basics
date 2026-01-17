package com.dev.loose_coupling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainIoC {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationIoC.xml");

        UserManager userManagerWithUserDataProvider = (UserManager) context.getBean("userManagerWithUserDataProvider");
        System.out.println(userManagerWithUserDataProvider.getUserInfo());

        UserManager userManagerWithNewDatabaseProvider = (UserManager) context.getBean("userManagerWithNewDatabaseProvider");
        System.out.println(userManagerWithNewDatabaseProvider.getUserInfo());

        UserManager userManagerWithWebServiceProvider = (UserManager) context.getBean("userManagerWithWebServiceProvider");
        System.out.println(userManagerWithWebServiceProvider.getUserInfo());

    }
}

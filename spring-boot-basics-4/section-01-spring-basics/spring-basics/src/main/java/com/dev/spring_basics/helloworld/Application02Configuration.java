package com.dev.spring_basics.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) {
};

@Configuration
public class Application02Configuration {

    @Bean
    public String name() {
        return "JavaDeveloper";
    }

    @Bean
    public int age() {
        return 17;
    }

    @Bean
    public Person person() {
        return new Person("Alin", 17, new Address("Sibiu", "Calea Dumbravii"));
    }

    @Primary
    @Bean(name = "customAddress")
    public Address address() {
        return new Address("Zavoi", "Sibiu");
    }

    @Bean(name = "customAddress2")
    public Address address2() {
        return new Address("Zavoi2", "Sibiu2");
    }

    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person3Parameters(String name, int age, @Qualifier("customAddress") Address address) {
        return new Person(name, age, address);
    }
}

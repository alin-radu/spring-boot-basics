package com.dev.spring_security_basics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableWebSecurity(debug = true)
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        var context = SpringApplication.run(Application.class, args);

    }

//    @Bean
//    public CommandLineRunner logInfo(FilterChainProxy filterChainProxy) {
//        return args -> {
//            Helpers.printSecurityFilters(filterChainProxy);
//        };
//    }
}

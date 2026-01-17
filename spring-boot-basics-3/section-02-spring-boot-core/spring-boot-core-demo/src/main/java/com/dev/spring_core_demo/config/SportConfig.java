package com.dev.spring_core_demo.config;

import com.dev.spring_core_demo.common.Coach;
import com.dev.spring_core_demo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean // the bean id is the method name, swimCoach
//    @Bean("aquaticCoach") // define a custom id
    public Coach swimCoach() {
        return new SwimCoach();
    }

}

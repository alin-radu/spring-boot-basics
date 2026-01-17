package com.dev.spring_security_basics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

//@Configuration
public class BasicAuthSecurityConfiguration {
    enum Role {
        USER,
        ADMIN;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(
                        auth -> {
                            auth.anyRequest().authenticated();
                        })
                .sessionManagement(
                        session ->
                                session.sessionCreationPolicy(
                                        SessionCreationPolicy.STATELESS)
                )
                .httpBasic(withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }

    @Bean
    public UserDetailsService userDetailService() {

        var devUser = User.withUsername("devUser")
                .password("{noop}test1234")
                .passwordEncoder(str -> passwordEncoder().encode(str))
                .roles(Role.ADMIN.name())
                .build();

        var adminUser = User.withUsername("devAdmin")
                .password("{noop}test1234")
                .passwordEncoder(str -> passwordEncoder().encode(str))
                .roles(Role.ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager(devUser, adminUser);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

}

//SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//    http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
//    http.formLogin(withDefaults());
//    http.httpBasic(withDefaults());
//    return http.build();
//}

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedMethods("*")
//                        .allowedOrigins("http://localhost:3000");
//            }
//        };
//    }
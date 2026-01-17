package com.dev.spring_boot_rest_api_basics.controller;

import com.dev.spring_boot_rest_api_basics.model.HelloWorldModel;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private final MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/hello-bean")
    public HelloWorldModel helloWorldBean() {
        return new HelloWorldModel("Hello World");
    }

    @GetMapping("/hello/path-variable/{name}")
    public HelloWorldModel helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldModel(String.format("Hello World, %s", name));
    }

    @GetMapping("/hello-internationalized")
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();

        System.out.println(locale);

        return messageSource.getMessage(
                "good.morning.message", null, "Default Message", locale);
    }
}

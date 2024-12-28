package com.dev.spring_boot_basics.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String greet() {

        return "<h1>Hello World.</h1>";
    }

    @RequestMapping("/about")
    public String about() {
        return "Welcome to the About Page.";
    }
}

//@Controller
//public class HomeController {
//
//    @RequestMapping("/")
//    @ResponseBody
//    public String greet() {
//
//        return "Hello World";
//    }
//}

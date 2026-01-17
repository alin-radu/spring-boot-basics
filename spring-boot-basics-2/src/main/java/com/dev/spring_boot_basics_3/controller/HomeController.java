package com.dev.spring_boot_basics_3.controller;

import com.dev.spring_boot_basics_3.config.ContentCalendarProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class HomeController {

    private final ContentCalendarProperties properties;

    public HomeController(ContentCalendarProperties properties) {
        this.properties = properties;
    }

    @GetMapping("")
    public ContentCalendarProperties home() {
        return properties;
    }
}

//public class HomeController {
//
//    @Value("${cc.welcomeMessage: Default Welcome Message}")
//    private String welcomeMessage;
//
//    @Value("${cc.aboutMessage}")
//    private String about;
//
//    @GetMapping("/api/")
//    public Map<String, String> home() {
//        return Map.ofEntries(
//                Map.entry("welcomeMessage", welcomeMessage),
//                Map.entry("about", about)
//        );
//    }
//}

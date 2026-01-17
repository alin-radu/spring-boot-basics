package com.dev.component_scan_annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.dev.component_scan_annotation")
public class AppConfig {
}

package com.dev.spring_core_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@SpringBootApplication(
        scanBasePackages = {
                "com.dev.spring_core_demo",
                "com.dev.util"
        }
)
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

//        1️⃣ Creates the Spring Application Context
//        2️⃣ Starts Auto-Configuration
//        3️⃣ Scans for Components
//        4️⃣ Registers All Beans
//        5️⃣ Starts the Embedded Server (If Web App)
//        6️⃣ Executes Startup Hooks, CommandLineRunner, ApplicationRunner

/*
    Summary:
        It bootstraps the Spring Boot application by creating the application context,
    performing component scanning, applying auto-configuration,
    and starting the embedded web server if present.
 */

        SpringApplication.run(Application.class, args);
    }

}

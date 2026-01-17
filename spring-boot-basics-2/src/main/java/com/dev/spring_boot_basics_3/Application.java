package com.dev.spring_boot_basics_3;

import com.dev.spring_boot_basics_3.config.ContentCalendarProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

//public static void main(String[] args) {
//    ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//
//    AtomicInteger count = new AtomicInteger(1);
//    Arrays.stream(context.getBeanDefinitionNames())
//            .forEach((item) -> {
//                System.out.println(count + ". " + item);
//                count.getAndIncrement();
//            });
//}

//@Bean
//CommandLineRunner commandLineRunner(ContentRepository repository) {
//    return args -> {
//        System.out.println("You could insert some data in the DB. | Application");
//
//        Content content = new Content(
//                null,
//                "My Blog Post, from CommandLineRunner",
//                "My First blog post executed from CommandLineRunner",
//                Status.IN_PROGRESS,
//                Type.ARTICLE,
//                LocalDateTime.now(),
//                null,
//                "");
//
//        repository.save(content);
//    };
//}
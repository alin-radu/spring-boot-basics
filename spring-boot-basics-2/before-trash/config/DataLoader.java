package com.dev.spring_boot_basics_3.config;

import com.dev.spring_boot_basics_3.model.Content;
import com.dev.spring_boot_basics_3.repository.ContentRepository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

//@Profile("!dev")
@Component
public class DataLoader implements CommandLineRunner {
    private final ContentRepository repository;
    private final ObjectMapper objectMapper;

    public DataLoader(ContentRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            try (
                    InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")
            ) {
                repository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Content>>() {
                        }
                ));
            }
        }
    }
}

//public class DataLoader implements CommandLineRunner {
//    private final ContentRepository repository;
//
//    public DataLoader(ContentRepository repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("You could insert some data in the DB. | DataLoader");
//
//        Content content = new Content(
//                null,
//                "My Blog Post, from DataLoader",
//                "My First blog post executed from DataLoader",
//                Status.COMPLETED,
//                Type.ARTICLE,
//                LocalDateTime.now(),
//                null,
//                "");
//
//        repository.save(content);
//
//    }
//}

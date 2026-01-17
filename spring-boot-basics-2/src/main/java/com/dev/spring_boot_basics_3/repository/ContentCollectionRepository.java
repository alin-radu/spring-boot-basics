package com.dev.spring_boot_basics_3.repository;

import com.dev.spring_boot_basics_3.model.Content;
import com.dev.spring_boot_basics_3.model.Status;
import com.dev.spring_boot_basics_3.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * The ContentCollectionRepository class functions as an in-memory data repository
 * for managing Content objects in a Spring Boot application.
 * It provides basic CRUD operations (Create, Read, Update, Delete) and initializes
 * the repository with a sample Content object upon startup.
 * This setup is particularly useful for testing and development purposes,
 * enabling quick prototyping without needing a database.
 */

/*
    @Repository
    This annotation marks the class as a Spring repository component,
    therefore it will be scanned for and managed by the Spring container.
    This allows the class to be injected into other components.
 */

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    /*
     * The default constructor is provided.
     * It may be used to include any future initialization,
     * although it is currently empty.
     */
    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList
                .stream()
                .filter((c) -> c.id().equals(id))
                .findFirst();
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    /*
     * @PostConstruct: An annotation that indicates a method should be called after
     * the bean's properties have been set, useful for initializing data.
     */
    @PostConstruct
    private void init() {
        Content content = new Content(1,
                "My First Blog Post",
                "My first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");

        contentList.add(content);

    }

    public boolean existsById(Integer id) {
        return contentList
                .stream()
                .filter(c -> c.id().equals(id))
                .count() == 1;
    }

    public void deleteById(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
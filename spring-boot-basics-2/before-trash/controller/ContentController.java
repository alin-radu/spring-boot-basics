package com.dev.spring_boot_basics_3.controller;

import com.dev.spring_boot_basics_3.model.Content;
import com.dev.spring_boot_basics_3.model.Status;
import com.dev.spring_boot_basics_3.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/*
 * @RestController
 * Indicates that this class is a Spring MVC controller where
 * every method returns a Java object that is automatically serialized to JSON.
 */
/*
 * @RequestMapping
 * Maps all requests that start with /api/content to this controller.
 */

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {

//    private final ContentCollectionRepository repository;
//
//    public ContentController(ContentCollectionRepository repository) {
//        this.repository = repository;
//    }

//    private final ContentJdbcTemplateRepository repository;
//
//    public ContentController(ContentJdbcTemplateRepository repository) {
//        this.repository = repository;
//    }

    private final ContentRepository repository;

    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Content> findAll() {

        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {

        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found."));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content) {

        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Content content) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found.");
        }

        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found.");
        }

        repository.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword) {
        return repository.findAllByTitleContains(keyword);
    }

    @GetMapping("/filter/status/{status}")
    public List<Content> findAllByStatus(@PathVariable Status status) {
        System.out.println(status);
        return repository.findAllByStatus(status);
    }
}

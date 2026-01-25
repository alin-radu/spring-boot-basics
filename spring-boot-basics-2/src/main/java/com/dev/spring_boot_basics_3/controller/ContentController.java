package com.dev.spring_boot_basics_3.controller;

import com.dev.spring_boot_basics_3.model.Content;
import com.dev.spring_boot_basics_3.repository.ContentCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/contents")
public class ContentController {

    private final ContentCollectionRepository repository;

    public ContentController(ContentCollectionRepository contentCollectionRepository) {
        this.repository = contentCollectionRepository;
    }

    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{contentId}")
    public Content findContentById(@PathVariable Integer contentId) {
        return repository.findById(contentId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found."));
    }

    @PostMapping("")
    public void addContent(@RequestBody Content content) {
        this.repository.save(content);
    }

}

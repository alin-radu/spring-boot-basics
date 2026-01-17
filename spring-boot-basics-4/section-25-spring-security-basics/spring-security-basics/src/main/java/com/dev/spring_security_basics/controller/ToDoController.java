package com.dev.spring_security_basics.controller;

import com.dev.spring_security_basics.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static final List<Todo> TODOS_LIST = List.of(
            new Todo("dev1", "description1"),
            new Todo("dev2", "description2")
    );

    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        return TODOS_LIST;
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> getTodosByUserName(@PathVariable String username) {

        return TODOS_LIST.stream().filter(t -> t.username().equals(username)).toList();
    }

    @PostMapping("/users/{username}/todos")
    public void addTodosByUserName(@PathVariable String username, @RequestBody Todo todo) {
        logger.info("Create {} for {}", todo, username);
    }
};



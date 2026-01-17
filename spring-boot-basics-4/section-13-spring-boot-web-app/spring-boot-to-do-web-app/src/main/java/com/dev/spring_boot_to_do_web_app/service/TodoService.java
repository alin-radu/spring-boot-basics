package com.dev.spring_boot_to_do_web_app.service;

import com.dev.spring_boot_to_do_web_app.model.Todo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static int todosCount = 100;
    private static final List<Todo> todos = new ArrayList<>();

    static {

        todos.add(new Todo(++todosCount, "dev",
                "Learn AWS", LocalDate.now().plusYears(3), false));
        todos.add(new Todo(++todosCount, "dev",
                "Learn Azure", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount, "dev",
                "Learn Java", LocalDate.now().plusYears(1), false));
    }

    public TodoService() {
    }

    public List<Todo> findByUsername(String username) {
        return todos
                .stream()
                .filter(todo -> todo.getUsername().equalsIgnoreCase(username))
                .toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate) {
        Todo todo = new Todo(++todosCount, username, description, targetDate);
        todos.add(todo);
    }

    public void deleteTodoById(Integer id) {
        todos.removeIf(t -> t.getId() == id);
    }

    public Todo findById(Integer id) {
        return todos.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    public void updateTodo(@Valid Todo todo) {
        deleteTodoById(todo.getId());
        todos.add(todo);
    }
}

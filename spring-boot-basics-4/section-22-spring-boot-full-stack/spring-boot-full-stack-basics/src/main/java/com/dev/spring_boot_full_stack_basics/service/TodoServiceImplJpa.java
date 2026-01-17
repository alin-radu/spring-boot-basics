package com.dev.spring_boot_full_stack_basics.service;

import com.dev.spring_boot_full_stack_basics.model.Todo;
import com.dev.spring_boot_full_stack_basics.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TodoServiceImplJpa implements TodoService {
    private final TodoRepository todoRepository;
    public TodoServiceImplJpa(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> findByUsername(String username) {
        return todoRepository.findByUsername(username);
    }

    @Override
    public Todo findById(Integer id) {
        return todoRepository.findById(id).orElse(null);
    }

    @Override
    public Todo addTodo(String username, String description, LocalDate targetDate) {
        Todo todo = new Todo(null, username, description, targetDate, false);

        todoRepository.save(todo);

        return todo;
    }

    @Override
    public void deleteTodoById(Integer id) {
        todoRepository.deleteById(id);
    }

    @Override
    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }
}

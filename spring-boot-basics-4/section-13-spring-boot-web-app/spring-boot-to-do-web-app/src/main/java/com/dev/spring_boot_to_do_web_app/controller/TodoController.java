package com.dev.spring_boot_to_do_web_app.controller;

import com.dev.spring_boot_to_do_web_app.model.Todo;
import com.dev.spring_boot_to_do_web_app.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String listAllTodos(@ModelAttribute("name") String name, ModelMap model) {
        String username = getLoggedInUserName();

        List<Todo> todos = todoService.findByUsername(username);
        model.addAttribute("todos", todos);

        return "listTodosPage";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String displayAddTodoPage(ModelMap model) {
        String username = getLoggedInUserName();
        LocalDate targetDate = LocalDate.now().plusYears(1);

        Todo todo = new Todo(0, username, "", targetDate, false);
        model.put("todo", todo);

        return "addTodoPage";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "addTodoPage";
        }

        String username = getLoggedInUserName();
        todoService.addTodo(username, todo.getDescription(), todo.getTargetDate());

        return "redirect:list-todos";
    }

    @RequestMapping(value = "delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteTodoById(id);

        return "redirect:list-todos";
    }

    @RequestMapping("update-todo")
    public String displayTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);

        return "addTodoPage";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "addTodoPage";
        }

        String username = getLoggedInUserName();
        todo.setUsername(username);
        todoService.updateTodo(todo);

        return "redirect:list-todos";
    }

    private static String getLoggedInUserName() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}


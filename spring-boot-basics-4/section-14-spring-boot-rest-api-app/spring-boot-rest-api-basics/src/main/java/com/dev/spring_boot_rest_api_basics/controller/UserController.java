package com.dev.spring_boot_rest_api_basics.controller;

import com.dev.spring_boot_rest_api_basics.exception.UserNotFoundException;
import com.dev.spring_boot_rest_api_basics.model.Post;
import com.dev.spring_boot_rest_api_basics.model.User;
import com.dev.spring_boot_rest_api_basics.repository.PostRepository;
import com.dev.spring_boot_rest_api_basics.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

//    private final UserDao userService;
//
//    public UserController(UserDao userDao) {
//        this.userService = userDao;
//    }

    private final UserService userService;
    private final PostRepository postRepository;
    public UserController(UserService userService, PostRepository postRepository) {
        this.userService = userService;
        this.postRepository = postRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        User user = userService.findUserById(id);

        if (user == null) {
            throw new UserNotFoundException("id: " + id);
        }

        return user;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User createdUser = userService.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Integer id) {
        User user = userService.findUserById(id);

        if (user == null) {
            throw new UserNotFoundException("id: " + id);
        }

        userService.deleteUserById(id);
    }

    @GetMapping("/{id}/posts")
    public List<Post> getPostsByUserId(@PathVariable Integer id) {
        User user = userService.findUserById(id);

        if (user == null) {
            throw new UserNotFoundException("id: " + id);
        }

        return user.getPosts();
    }

    @PostMapping("/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable Integer id, @Valid @RequestBody Post post) {
        User user = userService.findUserById(id);

        if (user == null) {
            throw new UserNotFoundException("id: " + id);
        }

        post.setUser(user);

        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}


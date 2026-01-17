package com.dev.spring_boot_rest_api_basics.service;

import com.dev.spring_boot_rest_api_basics.model.User;
import com.dev.spring_boot_rest_api_basics.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Nullable
    public User findUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User save(@Valid User user) {
        return userRepository.save(user);
    }
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }
}

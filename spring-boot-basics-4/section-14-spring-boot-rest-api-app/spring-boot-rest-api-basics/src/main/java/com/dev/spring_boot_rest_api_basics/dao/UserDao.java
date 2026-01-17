package com.dev.spring_boot_rest_api_basics.dao;

import com.dev.spring_boot_rest_api_basics.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {

    public static List<User> users = new ArrayList<>();

    private static Integer usersCount = 1;

    static {
        users.add(new User(usersCount++, "Name1", LocalDate.now().minusYears(30)));
        users.add(new User(usersCount++, "Name2", LocalDate.now().minusYears(20)));
        users.add(new User(usersCount++, "Name3", LocalDate.now().minusYears(10)));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(usersCount++);

        users.add(user);

        return user;
    }

    public User findUserById(Integer id) {
        return users
                .stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void deleteUserById(Integer id) {
        users.removeIf(u -> u.getId().equals(id));
    }
}

package com.dev.spring_boot_rest_api_basics.repository;

import com.dev.spring_boot_rest_api_basics.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

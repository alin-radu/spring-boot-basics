package com.dev.spring_boot_rest_api_basics.repository;

import com.dev.spring_boot_rest_api_basics.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}

package com.dev.social_media_platform.repositories;

import com.dev.social_media_platform.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}

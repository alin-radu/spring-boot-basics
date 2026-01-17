package com.dev.social_media_platform.repositories;

import com.dev.social_media_platform.models.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialUserRepository extends JpaRepository<SocialUser,Long> {
}

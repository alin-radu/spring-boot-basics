package com.dev.social_media_platform.repositories;

import com.dev.social_media_platform.models.SocialProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialProfileRepository extends JpaRepository<SocialProfile, Long> {
}

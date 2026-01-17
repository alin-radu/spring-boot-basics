package com.dev.social_media_platform.services;

import com.dev.social_media_platform.models.SocialUser;
import com.dev.social_media_platform.repositories.SocialUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {

    private final SocialUserRepository socialUserRepository;

    public SocialService(SocialUserRepository socialUserRepository) {
        this.socialUserRepository = socialUserRepository;
    }

    public List<SocialUser> getAllUsers() {
        return socialUserRepository.findAll();
    }

    // The CodeFlow
//    SocialUser user = new SocialUser();
//    SocialProfile profile = new SocialProfile();
//    profile.setDescription("My Description");
//
//    user.setSocialProfile(profile);
//    socialUserRepository.save(user);
    public SocialUser saveUser(SocialUser socialUser) {
        return socialUserRepository.save(socialUser);
    }

    public SocialUser deleteUser(Long id) {
        SocialUser socialUser = socialUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        socialUserRepository.delete(socialUser);
        return socialUser;
    }
}

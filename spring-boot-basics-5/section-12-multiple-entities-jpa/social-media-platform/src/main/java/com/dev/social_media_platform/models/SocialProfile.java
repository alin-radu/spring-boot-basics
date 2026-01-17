package com.dev.social_media_platform.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // User
    // SocialProfile is the owner in the SocialProfile <-> SocialUser relationship;
    // SocialProfile holds the @JoinColumn;
    // SocialUser holds the mappedBy;
    @OneToOne
    @JoinColumn(name = "social_user_id")
    @JsonIgnore
    private SocialUser user;

    // description
    private String description;

    public void setSocialUser(SocialUser socialUser) {
        this.user = socialUser;
        if (user.getSocialProfile() != this)
            user.setSocialProfile(this);
    }
}

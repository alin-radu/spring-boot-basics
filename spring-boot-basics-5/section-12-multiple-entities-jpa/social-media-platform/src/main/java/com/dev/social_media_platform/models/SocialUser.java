package com.dev.social_media_platform.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Profile
    // SocialUser is NOT the owner in the SocialProfile <-> SocialUser relationship;
    // SocialProfile holds the @JoinColumn;
    // SocialUser holds the mappedBy;
    @OneToOne(mappedBy = "user",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private SocialProfile socialProfile;

    // Post
    // SocialUser is NOT the owner in the Post <-> SocialUser relationship;
    // Post holds the @JoinColumn;
    // SocialUser holds the mappedBy;
    @OneToMany(mappedBy = "socialUser",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Post> posts = new ArrayList<>();

    // Group
    // SocialUser is the owner in the SocialUser <-> SocialGroup relationship;
    // SocialUser because holds the @JoinTable;
    // SocialGroups holds the mappedBy;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "social_user_social_group",
            joinColumns = @JoinColumn(name = "social_user_id"),
            inverseJoinColumns = @JoinColumn(name = "social_group_id")
    )
    private Set<SocialGroup> groups = new HashSet<>();

    public void setSocialProfile(SocialProfile socialProfile) {
        if (socialProfile != null) {
            socialProfile.setUser(this);
        }
        this.socialProfile = socialProfile;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : System.identityHashCode(this);
    }
}

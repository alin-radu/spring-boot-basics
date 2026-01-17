package com.dev.tight_coupling;

public class UserManager {

    private final UserDatabase userDatabase = new UserDatabase();

    public String getUserInfo() {
        return userDatabase.getUserDetails();
    }
}

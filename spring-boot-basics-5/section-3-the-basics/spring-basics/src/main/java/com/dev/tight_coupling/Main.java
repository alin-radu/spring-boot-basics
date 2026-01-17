package com.dev.tight_coupling;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();

        System.out.println("user details: " + userManager.getUserInfo());
    }
}

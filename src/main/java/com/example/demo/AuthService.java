package com.example.demo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AuthService {
    // Keep users in a static list so they persist during runtime memory
    private static final List<User> users = new ArrayList<>();

    static {
        // Default seed accounts
        users.add(new User("drsmith", "password123", "INSTRUCTOR"));
        users.add(new User("katie", "password456", "STUDENT"));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public boolean registerUser(String username, String password, String role) {
        // Prevent duplicate usernames
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(username.trim())) {
                return false;
            }
        }
        users.add(new User(username.trim(), password.trim(), role.toUpperCase().trim()));
        return true;
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username.trim()) && user.getPassword().equals(password.trim())) {
                return user;
            }
        }
        return null;
    }
}

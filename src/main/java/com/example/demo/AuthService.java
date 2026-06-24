package com.example.demo;

import com.example.demo.model.User;
import java.util.ArrayList;
import java.util.List;

public class AuthService {
    private static final List<User> users = new ArrayList<>();

    public boolean registerUser(String username, String password, String role) {
        if (findByUsername(username) != null) return false;
        users.add(new User(username, password, role));
        return true;
    }

    public User findByUsername(String username) {
        return users.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
    }
    
    public void saveUser(User user) {
        users.removeIf(u -> u.getUsername().equals(user.getUsername()));
        users.add(user);
    }
    
    public User login(String username, String password) {
        return users.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
    }
}

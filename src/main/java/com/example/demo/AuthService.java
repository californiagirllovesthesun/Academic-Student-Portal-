package com.example.demo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AuthService {

    private List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        File file = new File("user.txt");

        if (!file.exists()) {
            System.out.println("❌ Error: user.txt not found in the root directory!");
            return users;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    users.add(new User(parts[0].trim(), parts[1].trim(), parts[2].trim()));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user.txt: " + e.getMessage());
        }
        return users;
    }

    public User login(String username, String password) {
        List<User> users = loadUsers();
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username.trim()) && user.getPassword().equals(password.trim())) {
                return user;
            }
        }
        return null;
    }
}

package com.example.demo.model;

public class User {
    private String username;
    private String password;
    private String role;
    private String email;
    private String phone;

    public User() {}
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
}

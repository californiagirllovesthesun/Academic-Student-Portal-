package com.example.demo.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String email;
    private String phoneNumber;
    private String profilePhotoUrl;
    private double gradeAverage;
    
    @ElementCollection
    private List<String> assignments = new ArrayList<>();

    // Standard constructor, getters, and setters
    public Student() {}
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    // Add remaining getters/setters...
}
package com.example.demo.model;
import jakarta.persistence.*;
@Entity
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    // Getters and setters...
}

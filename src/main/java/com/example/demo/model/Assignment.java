package com.example.demo.model;
import jakarta.persistence.*;
@Entity
public class Assignment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    private Course course;
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public void setCourse(Course course) { this.course = course; }
}

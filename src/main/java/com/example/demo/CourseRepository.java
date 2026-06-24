package com.example.demo;
package com.example.demo.repository; // Add this line

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Course; // Assuming Course model is in the main demo package

public interface CourseRepository extends JpaRepository<Course, Long> {
}

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
}
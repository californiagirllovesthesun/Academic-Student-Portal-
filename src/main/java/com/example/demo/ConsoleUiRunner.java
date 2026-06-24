package com.example.demo;

import com.example.demo.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class ConsoleUiRunner implements CommandLineRunner {

    private final CourseRepository courseRepository;

    // Inject the repository so we can save data
    public ConsoleUiRunner(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Clear out any old data just in case
        courseRepository.deleteAll();

        // Seed sample courses so the dashboards don't crash on empty data
        Course c1 = new Course();
        c1.setCourseCode("CS101");
        c1.setCourseName("Introduction to Computer Science");
        c1.setCurrentAssignmentName("Lab 1: Hello World");
        c1.setStudentGradeAverage(92.5);
        courseRepository.save(c1);

        Course c2 = new Course();
        c2.setCourseCode("MATH201");
        c2.setCourseName("Calculus I");
        c2.setCurrentAssignmentName("Homework 2");
        c2.setStudentGradeAverage(84.0);
        courseRepository.save(c2);

        System.out.println("🌐 Web UI Portal Active. H2 Database successfully seeded with sample courses!");
    }
}
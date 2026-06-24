package com.example.demo;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;

import com.example.demo.model.Course;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
        
        this.courseRepository.deleteAll(); // Clears any old bugged data
        
        this.courseRepository.save(new Course(
            "Intro to Java", 
            "CS-101", 
            "Dr. Smith", 
            "Office Hours: Mon 2-4pm", 
            "MWF 10:00 AM", 
            "Room 302", 
            4, 
            "No students enrolled yet",
            "Not provided", // For studentEmailString
            "Not provided", // For studentPhoneNumberString
            "Standard Track" // For studentSchedulingInfo
        ));
    } // <-- FIXED: Added this missing closing brace for the constructor!

    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/{courseCode}")
    public Course getCourseByCode(@PathVariable String courseCode) {
        return courseRepository.findById(courseCode).orElse(null); 
    }

    @PostMapping
    public String addCourse(@RequestBody Course newCourse) {
        if (courseRepository.existsById(newCourse.getCourseCode())) {
            return "Error: A course with code " + newCourse.getCourseCode() + " already exists!";
        }
        courseRepository.save(newCourse);
        return "Success! Added course: " + newCourse.getCourseName();
    }

   @PutMapping("/{courseCode}")
    public String updateCourse(@PathVariable String courseCode, @RequestBody Course updatedCourseDetails) {
        return courseRepository.findById(courseCode)
                .map(course -> {
                    // Your existing updates:
                    course.setCourseName(updatedCourseDetails.getCourseName());
                    course.setInstructorName(updatedCourseDetails.getInstructorName());
                    course.setInstructorInfo(updatedCourseDetails.getInstructorInfo());
                    course.setMeetingTime(updatedCourseDetails.getMeetingTime());
                    course.setRoomNumber(updatedCourseDetails.getRoomNumber());
                    course.setCredits(updatedCourseDetails.getCredits());
                    course.setStudentRoster(updatedCourseDetails.getStudentRoster());
                    
                    // 📍 PASTE THE 3 NEW LINES RIGHT HERE:
                    course.setStudentEmailString(updatedCourseDetails.getStudentEmailString());
                    course.setStudentPhoneNumberString(updatedCourseDetails.getStudentPhoneNumberString());
                    course.setStudentSchedulingInfo(updatedCourseDetails.getStudentSchedulingInfo());
                    
                    // Save everything back to the database:
                    courseRepository.save(course);
                    return "Success! Updated course: " + courseCode;
                })
                .orElse("Error: Course with code " + courseCode + " not found.");
    }

    @DeleteMapping("/{courseCode}")
    public String deleteCourse(@PathVariable String courseCode) {
        if (courseRepository.existsById(courseCode)) {
            courseRepository.deleteById(courseCode);
            return "Success! Deleted course: " + courseCode;
        }
        return "Error: Course with code " + courseCode + " not found.";
    }
}
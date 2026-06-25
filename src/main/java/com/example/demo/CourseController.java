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
        
        // Only clear if you want to wipe data on every restart
        this.courseRepository.deleteAll(); 
        
        // Seed an initial course properly
        Course initialCourse = new Course();
        initialCourse.setCourseCode("CS-101");
        initialCourse.setCourseName("Intro to Java");
        initialCourse.setInstructorName("Dr. Smith");
        initialCourse.setInstructorInfo("Office Hours: Mon 2-4pm");
        initialCourse.setMeetingTime("MWF 10:00 AM");
        initialCourse.setRoomNumber("Room 302");
        initialCourse.setCredits("4");
        initialCourse.setStudentRoster("No students enrolled yet");
        initialCourse.setStudentEmailString("Not provided");
        initialCourse.setStudentPhoneNumberString("Not provided");
        initialCourse.setStudentSchedulingInfo("Standard Track");
        initialCourse.setCurrentAssignmentName("N/A");
        initialCourse.setStudentGradeAverage(0.0);
        
        this.courseRepository.save(initialCourse);
    }
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
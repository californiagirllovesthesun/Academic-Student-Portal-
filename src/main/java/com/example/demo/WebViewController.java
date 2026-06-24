package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller // 📍 MUST be @Controller, not @RestController!
@RequestMapping("/portal")
public class WebViewController {

    private final AuthService authService = new AuthService();
    private final CourseRepository courseRepository;

    public WebViewController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Looks for templates/login.html
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password, Model model) {
        User user = authService.login(username, password);
        if (user == null) {
            model.addAttribute("error", "Invalid credentials. Try again.");
            return "login";
        }
        if (user.getRole().equalsIgnoreCase("INSTRUCTOR")) {
            return "redirect:/portal/instructor";
        } else {
            return "redirect:/portal/student?name=" + username;
        }
    }

    @GetMapping("/instructor")
    public String showInstructorDashboard(Model model) {
        List<Course> courses = courseRepository.findAll();
        model.addAttribute("courses", courses);
        return "instructor"; // Looks for templates/instructor.html
    }

    @GetMapping("/student")
    public String showStudentDashboard(@RequestParam(name="name") String studentName, Model model) {
        List<Course> courses = courseRepository.findAll();
        model.addAttribute("courses", courses);
        model.addAttribute("studentName", studentName);
        return "student"; // Looks for templates/student.html
    }

    @PostMapping("/instructor/update-grade")
    public String updateGrade(@RequestParam String courseCode, 
                              @RequestParam String assignmentName, 
                              @RequestParam double grade) {
        courseRepository.findById(courseCode).ifPresent(course -> {
            course.setCurrentAssignmentName(assignmentName);
            course.setStudentGradeAverage(grade);
            courseRepository.save(course);
        });
        return "redirect:/portal/instructor";
    }
}

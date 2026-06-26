package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Course;

@Controller
@RequestMapping("/portal") // All paths in this file will start with /portal
public class PortalController {

    @GetMapping("/")
    public String index() { 
        return "redirect:/portal/login"; 
    }

    // Handles the initial loading of the login page
    @GetMapping("/login")
    public String showLoginPage() { 
        return "login"; 
    }

    // Handles the FORM submission (The "Sign In" button)
    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password) {
        // Add your authentication logic here
        return "redirect:/portal/student?username=" + username; 
    }

    // Handles the "Create Account" link
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; 
    }
}

    @GetMapping("/student")
    public String showStudentDashboard(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("courses", Course.getStudentCourses());
        return "student"; // Maps to templates/student.html
    }

    @GetMapping("/instructor")
    public String showInstructorDashboard(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("courses", Course.getInstructorCourses());
        return "instructor"; // Maps to templates/instructor.html
    }
}
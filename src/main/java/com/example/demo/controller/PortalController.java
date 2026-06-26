package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Course;

@Controller
@RequestMapping("/portal")
public class PortalController {

    @GetMapping("/")
    public String index() { 
        return "redirect:/portal/login"; 
    }

    @GetMapping("/login")
    public String showLoginPage() { 
        return "login"; 
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password) {
        return "redirect:/portal/student?username=" + username; 
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; 
    }

    @GetMapping("/student")
    public String showStudentDashboard(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("courses", Course.getStudentCourses());
        return "student";
    }

    @GetMapping("/instructor")
    public String showInstructorDashboard(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("courses", Course.getInstructorCourses());
        return "instructor";
    }
}
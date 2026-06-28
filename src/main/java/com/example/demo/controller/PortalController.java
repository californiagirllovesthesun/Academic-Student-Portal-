package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Course;

@Controller
@RequestMapping("/portal")
public class PortalController {

    // Adding a leading slash here makes it match "/" instead of "/portal/"
    @GetMapping({"/", ""}) 
    public String index() { 
        return "redirect:/portal/login"; 
    }

    @GetMapping("/login")
    public String showLoginPage() { 
        return "login"; 
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password) {
        // Logic: Simulate role check based on username
        if (username.toLowerCase().contains("instructor")) {
            return "redirect:/portal/instructor?username=" + username;
        } else {
            return "redirect:/portal/student?username=" + username;
        }
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; 
    }

    @GetMapping("/student")
    public String showStudentDashboard(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("courses", Course.getStudentCourses());
        
        System.out.println("DEBUG: Courses size is " + Course.getStudentCourses().size());
        
        return "student";
    }

    @GetMapping("/instructor")
    public String showInstructorDashboard(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("courses", Course.getInstructorCourses());
        return "instructor";
    }
@PostMapping("/save-profile")
    public String saveProfile(@RequestParam String username, 
                              @RequestParam String email, 
                              @RequestParam String phone) {
        
        // Debug: Log the received data to the Render console
        System.out.println("DEBUG: Updating profile for " + username);
        System.out.println("DEBUG: New Email: " + email);
        System.out.println("DEBUG: New Phone: " + phone);
        
        // After "saving," redirect the user back to their dashboard
        return "redirect:/portal/student?username=" + username;
    }



}
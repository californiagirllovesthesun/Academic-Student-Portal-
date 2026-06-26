package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortalController {
    
    @GetMapping("/portal-instructor")
    public String instructor() {
        return "instructor"; // Spring automatically looks for templates/instructor.html
    }

    @GetMapping("/portal-of-student")
    public String student() {
        return "student"; // Spring automatically looks for templates/student.html
    }
}
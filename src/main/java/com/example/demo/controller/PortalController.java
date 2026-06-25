package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortalController {
    
    @GetMapping("/instructor")
    public String instructor() {
        // This maps the URL /instructor to your static file
        return "forward:/instructor.html"; 
    }

    @GetMapping("/student")
    public String student() {
        // You can add one for your student page too!
        return "forward:/student.html"; 
    }
}
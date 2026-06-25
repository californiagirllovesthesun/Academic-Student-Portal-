package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortalController {
    
    @GetMapping("/portal-instructor")
    public String instructor() {
        // This maps the URL /instructor to your static file
        return "forward:/portal/instructor.html"; 
    }

    @GetMapping("/portal-of-student")
    public String student() {
        // You can add one for your student page too!
        return "forward:/portal/student.html"; 
    }
}
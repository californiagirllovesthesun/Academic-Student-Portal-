package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {
    @Autowired private StudentRepository studentRepository;

    @GetMapping("/register")
    public String showRegisterForm() { return "register"; }

    @PostMapping("/register")
    public String registerStudent(@ModelAttribute Student student) {
        // In a production app, always hash your passwords!
        studentRepository.save(student);
        return "redirect:/login";
    }
}

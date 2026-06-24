package com.example.demo.controller;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;
@Controller
public class StudentController {
    @Autowired private CourseRepository courseRepository;
    @GetMapping("/student")
    public String showStudentDashboard(Model model, Principal principal) {
        model.addAttribute("courses", courseRepository.findAll());
        model.addAttribute("username", principal != null ? principal.getName() : "Student");
        return "student";
    }
}

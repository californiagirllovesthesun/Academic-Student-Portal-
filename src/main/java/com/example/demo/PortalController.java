package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.service.CourseService; // Import your service
import org.springframework.beans.factory.annotation.Autowired; // Import for dependency injection
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/portal")
public class PortalController {
    
    // Inject the service instead of hard-instantiating it
    @Autowired
    private CourseService courseService;
    
    private final AuthService authService = new AuthService();

    @GetMapping("/")
    public String index() { return "redirect:/portal/login"; }

    @GetMapping("/login")
    public String showLoginPage() { return "login"; }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password, Model model) {
        User user = authService.login(username, password);
        if (user != null) {
            return user.getRole().equals("STUDENT") ? "redirect:/portal/student?username=" + user.getUsername() : "redirect:/portal/instructor?username=" + user.getUsername();
        }
        model.addAttribute("error", "Invalid credentials.");
        return "login";
    }

    @PostMapping("/save-profile")
    public String saveProfile(@RequestParam String username, @RequestParam String email, @RequestParam String phone) {
        User user = authService.findByUsername(username);
        if (user != null) {
            user.setEmail(email);
            user.setPhone(phone);
            authService.saveUser(user);
        }
        return "redirect:/portal/student?username=" + username;
    }

    @GetMapping("/register")
    public String showRegisterPage() { return "register"; }

    @PostMapping("/register")
    public String handleRegister(@RequestParam String username, @RequestParam String password, @RequestParam String role, Model model) {
        if (authService.registerUser(username, password, role)) return "redirect:/portal/login";
        model.addAttribute("error", "Username taken.");
        return "register";
    }

    @GetMapping("/student")
    public String showStudentDashboard(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        // Using the service instead of the static method
        model.addAttribute("courses", courseService.getAllCourses());
        return "student";
    }

    @GetMapping("/instructor")
    public String showInstructorDashboard(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        // Using the service instead of the static method
        model.addAttribute("courses", courseService.getAllCourses());
        return "instructor";
    }
}
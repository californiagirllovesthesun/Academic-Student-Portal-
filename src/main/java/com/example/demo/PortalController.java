package com.example.demo;

import com.example.demo.model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/portal")
public class PortalController {

    private final AuthService authService = new AuthService();
    private static final Map<String, String> profilePictures = new HashMap<>();

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

    @GetMapping("/register")
    public String showRegisterPage() { return "register"; }

    @PostMapping("/register")
    public String handleRegister(@RequestParam String username, @RequestParam String password, @RequestParam String role, 
                                 @RequestParam(required=false) String fullName, @RequestParam(required=false) String email, Model model) {
        if (authService.registerUser(username, password, role)) {
            return "redirect:/portal/login";
        }
        model.addAttribute("error", "Username taken.");
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

    @PostMapping("/broadcast-ta")
    @ResponseBody
    public String broadcastMessage(@RequestParam String message) {
        return "Message Broadcasted: " + message;
    }

    @PostMapping("/add-assignment")
    public String addAssignment(@RequestParam String courseCode, @RequestParam String assignmentName) {
        return "redirect:/portal/instructor?username=admin";
    }

    @GetMapping("/grade-submissions")
    public String showGradeSubmissions() { return "generic-info"; }

    @GetMapping("/student-roster")
    public String showStudentRoster() { return "generic-info"; }
}

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

    // Redirect root to login page
    @GetMapping("/")
    public String index() {
        return "redirect:/portal/login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password, Model model) {
        User user = authService.login(username, password);
        if (user != null) {
            if (user.getRole().equals("STUDENT")) {
                return "redirect:/portal/student?username=" + user.getUsername();
            } else {
                return "redirect:/portal/instructor?username=" + user.getUsername();
            }
        }
        model.addAttribute("error", "Invalid credentials. Try again.");
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    
@PostMapping("/register")
public String handleRegister(@RequestParam String username, 
                             @RequestParam String password, 
                             @RequestParam String role,
                             @RequestParam(required=false) String fullName,
                             @RequestParam(required=false) String email, 
                             Model model) {
    boolean success = authService.registerUser(username, password, role);
    if (success) {
        model.addAttribute("success", "Registration successful! Please sign in.");
        return "login";
    }
    model.addAttribute("error", "Username already exists.");
    return "register";
}
    @GetMapping("/student")
    public String showStudentDashboard(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("courses", Course.getStudentCourses());
        model.addAttribute("profilePic", profilePictures.getOrDefault(username, null));
        return "student";
    }

    @GetMapping("/instructor")
    public String showInstructorDashboard(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("courses", Course.getInstructorCourses());
        model.addAttribute("profilePic", profilePictures.getOrDefault(username, null));
        return "instructor";
    }

    @PostMapping("/upload-profile")
    public String handleProfileUpload(@RequestParam String username, @RequestParam String role, @RequestParam("photo") MultipartFile file, Model model) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String base64Image = Base64.getEncoder().encodeToString(bytes);
                profilePictures.put(username, "data:" + file.getContentType() + ";base64," + base64Image);
            } catch (Exception e) {
                System.out.println("Error saving photo: " + e.getMessage());
            }
        }
        String dashboard = role.equals("STUDENT") ? "student" : "instructor";
        return "redirect:/portal/" + dashboard + "?username=" + username;
    }

    @GetMapping("/grade-submissions")
    public String showGradeSubmissions(Model model) {
        model.addAttribute("message", "Grade submissions page under construction.");
        return "generic-info";
    }

    @GetMapping("/student-roster")
    public String showStudentRoster(Model model) {
        model.addAttribute("message", "Student roster page under construction.");
        return "generic-info";
    }
}

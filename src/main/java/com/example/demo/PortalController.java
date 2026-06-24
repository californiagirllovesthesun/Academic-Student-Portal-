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

    @GetMapping("/student")
    public String showStudentDashboard(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("courses", Course.getStudentCourses());
        model.addAttribute("profilePic", profilePictures.getOrDefault(username, null));
        return "student";
    }

    @PostMapping("/upload-profile")
    public String handleProfileUpload(@RequestParam String username, @RequestParam("photo") MultipartFile file, Model model) {
        if (!file.isEmpty()) {
            try {
                String base64Image = Base64.getEncoder().encodeToString(file.getBytes());
                profilePictures.put(username, "data:" + file.getContentType() + ";base64," + base64Image);
            } catch (Exception e) { e.printStackTrace(); }
        }
        return "redirect:/portal/student?username=" + username;
    }
}

package com.example.demo;

import com.example.demo.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/portal")
public class PortalController {
    private final AuthService authService = new AuthService();

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
    
    // ... include your existing getMapping routes here ...
}

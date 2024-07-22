package com.example.Task.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Task.Entity.User;
import com.example.Task.Service.UserService;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Task.Entity.User;
import com.example.Task.Service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    // other endpoints like login, forgot password
}

*/





@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User(null, null, null, null, null, null, null, null));
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User(null, null, null, null, null, null, null, null));
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, Model model) {
        User existingUser = userService.findByEmail(user.getEmail());
        if (existingUser != null) {
            return "redirect:/incidents";
        }
        model.addAttribute("error", "Invalid email or password");
        return "login";
    }

    @GetMapping("/forgot-password")
    public String showForgotPasswordForm(Model model) {
        model.addAttribute("user", new User(null, null, null, null, null, null, null, null));
        return "forgot-password";
    }

    @PostMapping("/forgot-password")
    public String resetPassword(@ModelAttribute User user, Model model) {
        User existingUser = userService.findByEmail(user.getEmail());
        if (existingUser != null) {
            // Implement password reset logic
            return "redirect:/login";
        }
        model.addAttribute("error", "Email not found");
        return "forgot-password";
    }
}
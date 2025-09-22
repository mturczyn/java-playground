package com.example.javawebapiauth.Controllers;

import com.example.javawebapiauth.Entities.AppUser;
import com.example.javawebapiauth.Repositories.UserRepository;
import com.example.javawebapiauth.Services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/signup")
    public String signup(@RequestBody AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User created!";
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> loginData) {
        AppUser user = userRepository.findByUsername(loginData.get("username"))
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(loginData.get("password"), user.getPassword())) {
            return jwtService.generateToken(user.getUsername());
        } else {
            throw new RuntimeException("Invalid password");
        }
    }
}


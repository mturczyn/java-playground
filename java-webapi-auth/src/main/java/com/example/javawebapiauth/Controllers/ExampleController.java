package com.example.javawebapiauth.Controllers;

import com.example.javawebapiauth.Services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/example")
public class ExampleController {
    @Autowired
    private JwtService jwtService;

    @GetMapping("/me")
    public String hello(@RequestHeader(value = "Authorization") String authHeader) {
        String token = authHeader.substring(7); // remove "Bearer "
        String username = jwtService.extractUsername(token);
        return "Hello "  + username;
    }
}

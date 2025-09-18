package com.example.demo.Controllers;

import com.example.demo.Models.ExampleEntity;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @PostMapping("/hello")
    public String helloPost(@RequestBody ExampleEntity requestBody) {
        return "Received entity data: " +  (new Gson().toJson(requestBody));
    }
}

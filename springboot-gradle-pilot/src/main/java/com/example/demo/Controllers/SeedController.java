package com.example.demo.Controllers;

import com.example.demo.DomainServices.DataSeederService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SeedController {

    private final DataSeederService seederService;

    public SeedController(DataSeederService seederService) {
        this.seederService = seederService;
    }

    @PostMapping("/seed")
    public ResponseEntity<String> seedData() {
        seederService.seed();
        return ResponseEntity.ok("Database seeded with sample products and mappings.");
    }
}

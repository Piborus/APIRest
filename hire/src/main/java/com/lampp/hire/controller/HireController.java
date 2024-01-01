package com.lampp.hire.controller;

import com.lampp.hire.service.HireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HireController {

    @Autowired
    private HireService hireService;

    @PostMapping("/shorten")
    public ResponseEntity<Long> shortenUrl(@RequestBody String originalUrl) {
        Long id = hireService.shortenUrl(originalUrl);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/expand/{id}")
    public ResponseEntity<String> expandUrl(@PathVariable Long id) {
        String originalUrl = hireService.expandUrl(id);
        if (originalUrl != null) {
            return ResponseEntity.ok(originalUrl);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

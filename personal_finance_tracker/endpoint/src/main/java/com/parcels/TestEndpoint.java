package com.parcels;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestEndpoint {

    @GetMapping
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok().body("Test Successful");
    }
}

package com.example.ctrler;

import org.joda.time.Instant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
    private static Instant now = Instant.now();

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @CrossOrigin(originPatterns = "http://localhost:7080")
    @GetMapping("/hi")
    public String hi() {
        return String.format("hi from %s", now);
    }
}

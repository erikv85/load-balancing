package com.example.ctrler;

import java.util.List;

import org.joda.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
    private static Instant now = Instant.now();

    @Autowired
    private EmployeeRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @CrossOrigin(originPatterns = "http://localhost:7080")
    @GetMapping("/hi")
    public String hi() {
        return String.format("hi from %s", now);
    }

    @CrossOrigin(originPatterns = "http://localhost:7080")
    @GetMapping("/all")
    public List<Employee> all() {
        return repository.findAll();
    }

    @CrossOrigin(originPatterns = "http://localhost:7080")
    @PostMapping("/new")
    public void newEmployee(@RequestBody Employee employee) {
        repository.save(employee);
    }
}

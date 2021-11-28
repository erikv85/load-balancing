package com.example.ctrler;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Data
public class Employee {
    @Id
    private String id;

    private String name;
    private String email;

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

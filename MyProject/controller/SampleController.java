package com.example.MyProject.controller;

import com.example.MyProject.bean.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class SampleController {

    @GetMapping
    public String defaultPage() {
        return "Hello! This is my first API";
    }

    @PostMapping("employee")
    public Employee postJsonRequestSample(@RequestBody Employee employee) {
        return employee;
    }
}
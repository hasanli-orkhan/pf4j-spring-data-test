package com.example.plugin.controller;

import com.example.plugin.model.Test;
import com.example.plugin.repository.TestRepository;
import com.example.plugin.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping
    public List<Test> getAll() {
        return testService.findAll();
    }
}

package com.example.app.controller;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController("/page")
public class PageController {

    @GetMapping
    public Map<String, String> getData() {
        return Map.of("key", "value");
    }

}

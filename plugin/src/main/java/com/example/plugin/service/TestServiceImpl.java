package com.example.plugin.service;

import com.example.plugin.model.Test;
import com.example.plugin.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    @Override
    public List<Test> findAll() {
        return testRepository.findAll();
    }
}

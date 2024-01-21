package com.example.plugin.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@RequiredArgsConstructor
@EntityScan(basePackages = "com.example.plugin.model")
@ComponentScan(basePackages = "com.example.plugin")
@EnableJpaRepositories(basePackages = "com.example.plugin.repository")
public class TestPluginConfig { }

package ru.hogwards.school.school.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/port")
public class InfoController {
    @Value("${server.port}")
    private String port;

    @GetMapping
    public String getPort() {
        return "server.port=" + port;
    }
}

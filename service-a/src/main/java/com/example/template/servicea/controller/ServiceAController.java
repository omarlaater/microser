package com.example.template.servicea.controller;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/api/a")
public class ServiceAController {

    @GetMapping("/hello")
    public Map<String, Object> hello(@RequestParam(defaultValue = "world") @NotBlank String name) {
        Map<String, Object> payload = new LinkedHashMap<>();
        payload.put("service", "service-a");
        payload.put("message", "Hello " + name);
        payload.put("timestamp", Instant.now().toString());
        return payload;
    }
}

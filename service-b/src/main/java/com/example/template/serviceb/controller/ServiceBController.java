package com.example.template.serviceb.controller;

import com.example.template.serviceb.client.ServiceAClient;
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
@RequestMapping("/api/b")
public class ServiceBController {

    private final ServiceAClient serviceAClient;

    public ServiceBController(ServiceAClient serviceAClient) {
        this.serviceAClient = serviceAClient;
    }

    @GetMapping("/relay")
    public Map<String, Object> relay(@RequestParam(defaultValue = "world") @NotBlank String name) {
        Map<String, Object> upstream = serviceAClient.hello(name);

        Map<String, Object> payload = new LinkedHashMap<>();
        payload.put("service", "service-b");
        payload.put("message", "Response relayed from service-a");
        payload.put("upstream", upstream);
        payload.put("timestamp", Instant.now().toString());
        return payload;
    }
}

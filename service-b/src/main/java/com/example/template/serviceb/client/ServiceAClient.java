package com.example.template.serviceb.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Component
public class ServiceAClient {

    private final RestClient serviceARestClient;

    public ServiceAClient(RestClient serviceARestClient) {
        this.serviceARestClient = serviceARestClient;
    }

    public Map<String, Object> hello(String name) {
        return serviceARestClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/a/hello").queryParam("name", name).build())
                .retrieve()
                .body(new ParameterizedTypeReference<Map<String, Object>>() {
                });
    }
}

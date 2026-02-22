package com.example.template.serviceb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ServiceAClientConfig {

    @Bean
    public RestClient serviceARestClient(
            RestClient.Builder restClientBuilder,
            @Value("${clients.service-a.base-url}") String baseUrl
    ) {
        return restClientBuilder.baseUrl(baseUrl).build();
    }
}

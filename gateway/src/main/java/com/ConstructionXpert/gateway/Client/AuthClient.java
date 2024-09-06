package com.ConstructionXpert.gateway.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "auth-service", url = "http://localhost:8200")
public interface AuthClient {

    @GetMapping("/Auth/validate")
    String validateToken(@RequestParam("token") String token);
}

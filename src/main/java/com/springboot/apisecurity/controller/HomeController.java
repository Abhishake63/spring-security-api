package com.springboot.apisecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String homeEndpoint() {
        return "Your api is secure !";
    }

    // curl -H "X-API-KEY: MY-KEY" -H "X-API-SECRET: MY-SECRET" http://localhost:8080/ -w "\n"
}
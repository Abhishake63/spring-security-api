package com.springboot.apisecurity.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.springboot.apisecurity.security.ApiKeyAuthentication;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class AuthenticationService {

    private String apiKey = "MY-KEY";

    private String apiSecret = "MY-SECRET";

    public Authentication getAuthentication(HttpServletRequest request) {

        String requestApiKey = request.getHeader("X-API-KEY");
        String requestApiSecret = request.getHeader("X-API-SECRET");

        if (!apiKey.equals(requestApiKey) || !apiSecret.equals(requestApiSecret)) {
            throw new BadCredentialsException("Invalid API Key");
        }
        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
    }
}

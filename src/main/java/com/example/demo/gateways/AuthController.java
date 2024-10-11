package com.example.demo.gateways;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {


    @PostMapping("/auth")
    public String auth(Authentication authentication) {
        return "";
    }
}

package com.inmobiliaria.inmobiliaria_backend.auth.controller;

import com.inmobiliaria.inmobiliaria_backend.auth.dto.AuthResponse;
import com.inmobiliaria.inmobiliaria_backend.auth.dto.LoginRequest;
import com.inmobiliaria.inmobiliaria_backend.auth.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }
}

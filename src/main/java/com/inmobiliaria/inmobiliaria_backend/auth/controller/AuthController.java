package com.inmobiliaria.inmobiliaria_backend.auth.controller;

import com.inmobiliaria.inmobiliaria_backend.auth.dto.AuthResponse;
import com.inmobiliaria.inmobiliaria_backend.auth.dto.LoginRequest;
import com.inmobiliaria.inmobiliaria_backend.auth.service.AuthService;
import com.inmobiliaria.inmobiliaria_backend.auth.service.TokenBlacklistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final TokenBlacklistService tokenBlacklistService;

    public AuthController(AuthService authService, TokenBlacklistService tokenBlacklistService) {
        this.authService = authService;
        this.tokenBlacklistService = tokenBlacklistService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        tokenBlacklistService.blacklistToken(token);
        return ResponseEntity.ok("Sesión cerrada exitosamente.");
    }

}

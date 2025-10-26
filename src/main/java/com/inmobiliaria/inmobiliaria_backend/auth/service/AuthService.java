package com.inmobiliaria.inmobiliaria_backend.auth.service;

import com.inmobiliaria.inmobiliaria_backend.auth.dto.AuthResponse;
import com.inmobiliaria.inmobiliaria_backend.auth.dto.LoginRequest;
import com.inmobiliaria.inmobiliaria_backend.auth.security.JwtUtil;
import com.inmobiliaria.inmobiliaria_backend.model.Usuario;
import com.inmobiliaria.inmobiliaria_backend.repository.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final UsuarioRepository userRepo;

    public AuthService(AuthenticationManager authManager, JwtUtil jwtUtil, UsuarioRepository userRepo) {
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
        this.userRepo = userRepo;
    }

    public AuthResponse login(LoginRequest request) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        Usuario usuario = userRepo.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtUtil.generateToken(usuario);
        return new AuthResponse(token);
    }

}

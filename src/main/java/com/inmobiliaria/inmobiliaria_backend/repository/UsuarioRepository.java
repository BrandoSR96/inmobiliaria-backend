package com.inmobiliaria.inmobiliaria_backend.repository;

import com.inmobiliaria.inmobiliaria_backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}

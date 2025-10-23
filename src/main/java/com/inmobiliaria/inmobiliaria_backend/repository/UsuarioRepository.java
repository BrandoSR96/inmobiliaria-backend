package com.inmobiliaria.inmobiliaria_backend.repository;

import com.inmobiliaria.inmobiliaria_backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}

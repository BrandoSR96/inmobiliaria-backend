package com.inmobiliaria.inmobiliaria_backend.repository;

import com.inmobiliaria.inmobiliaria_backend.model.Propiedad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropiedadRepository extends JpaRepository<Propiedad, Long> {
}

package com.inmobiliaria.inmobiliaria_backend.config;

import jakarta.persistence.PrePersist;
import com.inmobiliaria.inmobiliaria_backend.model.Propiedad;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PropiedadListener {

    @PrePersist
    public void prePersist(Propiedad propiedad) {
        propiedad.setFechaPublicacion(LocalDate.now());
    }

}

package com.inmobiliaria.inmobiliaria_backend.mapper;

import com.inmobiliaria.inmobiliaria_backend.enums.EstadoPropiedad;
import com.inmobiliaria.inmobiliaria_backend.enums.TipoPropiedad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropiedadResumenDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private Double precio;
    private Double metrosCuadrados;
    private String direccion;
    private String distrito;
    @Enumerated(EnumType.STRING)
    private TipoPropiedad tipo;
    @Enumerated(EnumType.STRING)
    private EstadoPropiedad estado;
    private String imagenUrl;
    private String servicios;
    private LocalDate fechaPublicacion;
}

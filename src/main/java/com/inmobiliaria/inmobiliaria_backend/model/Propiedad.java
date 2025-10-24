package com.inmobiliaria.inmobiliaria_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.inmobiliaria.inmobiliaria_backend.config.PropiedadListener;
import com.inmobiliaria.inmobiliaria_backend.enums.EstadoPropiedad;
import com.inmobiliaria.inmobiliaria_backend.enums.TipoPropiedad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(PropiedadListener.class)
@Table(name = "propiedad")
public class Propiedad {

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
    private String servicios;
    private LocalDate fechaPublicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "propiedad", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("propiedad")
    private List<Multimedia> multimedia;

}

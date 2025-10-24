package com.inmobiliaria.inmobiliaria_backend.dto;

import com.inmobiliaria.inmobiliaria_backend.enums.EstadoPropiedad;
import com.inmobiliaria.inmobiliaria_backend.enums.TipoPropiedad;
import com.inmobiliaria.inmobiliaria_backend.mapper.UsuarioResumenDTO;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropiedadDTO {
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    @Size(min = 3, max = 100, message = "El título debe tener entre 3 y 100 caracteres")
    private String titulo;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 10, max = 1000, message = "La descripción debe tener entre 10 y 1000 caracteres")
    private String descripcion;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor que 0")
    private Double precio;

    @NotNull(message = "Los metros cuadrados son obligatorios")
    @Positive(message = "Los metros cuadrados deben ser mayores que 0")
    private Double metrosCuadrados;

    @NotBlank(message = "La dirección es obligatoria")
    @Size(max = 255, message = "La dirección no debe exceder los 255 caracteres")
    private String direccion;

    @NotBlank(message = "El distrito es obligatorio")
    @Size(max = 100, message = "El distrito no debe exceder los 100 caracteres")
    private String distrito;

    @NotNull(message = "El tipo de propiedad es obligatorio")
    private TipoPropiedad tipo;

    @NotNull(message = "El estado de la propiedad es obligatorio")
    private EstadoPropiedad estado;

    @NotBlank(message = "Debe especificar los servicios (ejemplo: AGUA,LUZ,INTERNET)")
    @Size(max = 255, message = "Los servicios no deben exceder los 255 caracteres")
    private String servicios;

    private String fechaPublicacion;

    private UsuarioResumenDTO usuario;

    private List<MultimediaRespuestaDTO> multimedia;


}
package com.inmobiliaria.inmobiliaria_backend.dto;

import com.inmobiliaria.inmobiliaria_backend.enums.Rol;
import com.inmobiliaria.inmobiliaria_backend.mapper.PropiedadResumenDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "Debe ingresar un correo válido, por ejemplo: ejemplo@correo.com")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password;

    private Rol rol;
    private List<PropiedadDTO> propiedades;

}

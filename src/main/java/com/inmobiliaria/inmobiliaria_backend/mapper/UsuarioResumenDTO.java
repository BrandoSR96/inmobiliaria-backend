package com.inmobiliaria.inmobiliaria_backend.mapper;

import com.inmobiliaria.inmobiliaria_backend.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResumenDTO {
    private Long id;
    private String nombre;
    private String email;
    private Rol rol;
}

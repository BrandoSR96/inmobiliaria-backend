package com.inmobiliaria.inmobiliaria_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultimediaRespuestaDTO {
    private Long id;
    private String url;
    private String tipo;
}

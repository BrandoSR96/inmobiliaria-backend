package com.inmobiliaria.inmobiliaria_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultimediaCargaDTO {
    private MultipartFile archivo;
    private String tipo;
    private Long propiedadId;
}

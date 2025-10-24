package com.inmobiliaria.inmobiliaria_backend.mapper;

import com.inmobiliaria.inmobiliaria_backend.dto.MultimediaRespuestaDTO;
import com.inmobiliaria.inmobiliaria_backend.model.Multimedia;
import org.springframework.stereotype.Component;

@Component
public class MultimediaMapper {
    public MultimediaRespuestaDTO toDTO(Multimedia multimedia){
        return new MultimediaRespuestaDTO(
                multimedia.getId(),
                multimedia.getUrl(),
                multimedia.getTipo()
        );
    }
}

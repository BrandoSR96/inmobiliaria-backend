package com.inmobiliaria.inmobiliaria_backend.service;

import com.inmobiliaria.inmobiliaria_backend.dto.MultimediaCargaDTO;
import com.inmobiliaria.inmobiliaria_backend.model.Multimedia;
import com.inmobiliaria.inmobiliaria_backend.model.Propiedad;
import com.inmobiliaria.inmobiliaria_backend.repository.MultimediaRepository;
import com.inmobiliaria.inmobiliaria_backend.repository.PropiedadRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MultimediaService {

    private final AlmacenamientoService almacenamientoService;
    private final MultimediaRepository multimediaRepository;
    private final PropiedadRepository propiedadRepository;

    public MultimediaService(AlmacenamientoService almacenamientoService,
                             MultimediaRepository multimediaRepository,
                             PropiedadRepository propiedadRepository) {
        this.almacenamientoService = almacenamientoService;
        this.multimediaRepository = multimediaRepository;
        this.propiedadRepository = propiedadRepository;
    }

    @Transactional
    public void subirYVincular(MultimediaCargaDTO dto) {
        validarDTO(dto);

        Propiedad propiedad = propiedadRepository.findById(dto.getPropiedadId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "La propiedad con ID " + dto.getPropiedadId() + " no existe"
                ));


        validarTipoArchivo(dto.getArchivo(), dto.getTipo());

        String url = almacenamientoService.guardarArchivo(dto.getArchivo(), dto.getTipo());

        Multimedia multimedia = Multimedia.builder()
                .url(url)
                .tipo(dto.getTipo())
                .propiedad(propiedad)
                .build();

        multimediaRepository.save(multimedia);
    }

    private void validarDTO(MultimediaCargaDTO dto) {
        if (dto.getArchivo() == null || dto.getArchivo().isEmpty()) {
            throw new IllegalArgumentException("Debes subir un archivo válido");
        }

        if (dto.getTipo() == null || dto.getTipo().isBlank()) {
            throw new IllegalArgumentException("Debes especificar el tipo de archivo");
        }

        if (dto.getPropiedadId() == null) {
            throw new IllegalArgumentException("Debes especificar el ID de la propiedad");
        }
    }

    private void validarTipoArchivo(MultipartFile archivo, String tipo) {
        String mime = archivo.getContentType();

        if (tipo.equalsIgnoreCase("imagen") && (mime == null || !mime.startsWith("image/"))) {
            throw new IllegalArgumentException("El archivo no parece ser una imagen válida");
        }

        if (tipo.equalsIgnoreCase("video") && (mime == null || !mime.startsWith("video/"))) {
            throw new IllegalArgumentException("El archivo no parece ser un video válido");
        }
    }
}

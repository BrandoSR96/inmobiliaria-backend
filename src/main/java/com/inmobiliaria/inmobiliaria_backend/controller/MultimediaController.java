package com.inmobiliaria.inmobiliaria_backend.controller;

import com.inmobiliaria.inmobiliaria_backend.dto.MultimediaCargaDTO;
import com.inmobiliaria.inmobiliaria_backend.service.MultimediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/multimedia")
public class MultimediaController {

    private final MultimediaService multimediaService;

    @Autowired
    public MultimediaController(MultimediaService multimediaService) {
        this.multimediaService = multimediaService;
    }

    @PostMapping("/subir")
    public ResponseEntity<?> subirMultimedia(
            @RequestParam("archivo") MultipartFile archivo,
            @RequestParam("tipo") String tipo,
            @RequestParam("propiedadId") Long propiedadId
    ) {
        try {
            MultimediaCargaDTO dto = new MultimediaCargaDTO();
            dto.setArchivo(archivo);
            dto.setTipo(tipo);
            dto.setPropiedadId(propiedadId);

            multimediaService.subirYVincular(dto);
            return ResponseEntity.ok("Archivo subido y vinculado correctamente");
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}


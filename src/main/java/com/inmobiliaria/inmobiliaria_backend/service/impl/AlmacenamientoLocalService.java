package com.inmobiliaria.inmobiliaria_backend.service.impl;

import com.inmobiliaria.inmobiliaria_backend.service.AlmacenamientoService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class AlmacenamientoLocalService implements AlmacenamientoService {

    private final String rutaBase = "src/main/resources/static/media/";

    @Override
    public String guardarArchivo(MultipartFile archivo, String tipo) {
        try {
            String nombre = UUID.randomUUID() + "_" + archivo.getOriginalFilename();
            Path destino = Paths.get(rutaBase + nombre);
            Files.createDirectories(destino.getParent());
            Files.copy(archivo.getInputStream(), destino, StandardCopyOption.REPLACE_EXISTING);
            return "/media/" + nombre;
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar archivo local", e);
        }
    }
}


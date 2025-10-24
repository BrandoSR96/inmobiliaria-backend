package com.inmobiliaria.inmobiliaria_backend.service;

import org.springframework.web.multipart.MultipartFile;

public interface AlmacenamientoService {
    String guardarArchivo(MultipartFile archivo, String tipo);
}

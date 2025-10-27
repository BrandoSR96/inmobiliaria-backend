package com.inmobiliaria.inmobiliaria_backend.controller;

import com.inmobiliaria.inmobiliaria_backend.dto.PropiedadDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.inmobiliaria.inmobiliaria_backend.service.PropiedadService;

import java.util.List;

@RestController
@RequestMapping("/api/propiedades")
@RequiredArgsConstructor
public class PropiedadController {

    private final PropiedadService propiedadService;

    @PostMapping
    public ResponseEntity<PropiedadDTO> crear(@Valid @RequestBody PropiedadDTO dto) {
        PropiedadDTO creada = propiedadService.crearPropiedad(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @GetMapping
    public ResponseEntity<List<PropiedadDTO>> listar() {
        List<PropiedadDTO> propiedades = propiedadService.listar();
        return propiedades.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(propiedades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropiedadDTO> obtener(@PathVariable Long id) {
        PropiedadDTO dto = propiedadService.obtenerPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropiedadDTO> actualizar(@PathVariable Long id, @Valid @RequestBody PropiedadDTO dto) {
        PropiedadDTO actualizada = propiedadService.actualizar(id, dto);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        propiedadService.eliminar(id);
        return ResponseEntity.ok("Propiedad eliminada correctamente");
    }

    @GetMapping("/paginadas")
    public ResponseEntity<Page<PropiedadDTO>> listarPaginadas(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<PropiedadDTO> propiedades = propiedadService.listarPropiedades(pageable);
        return ResponseEntity.ok(propiedades);
    }


}

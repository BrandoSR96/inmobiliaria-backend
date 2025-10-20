package com.inmobiliaria.inmobiliaria_backend.service;

import com.inmobiliaria.inmobiliaria_backend.dto.PropiedadDTO;
import com.inmobiliaria.inmobiliaria_backend.model.Propiedad;
import lombok.RequiredArgsConstructor;
import com.inmobiliaria.inmobiliaria_backend.mapper.PropiedadMapper;
import org.springframework.stereotype.Service;
import com.inmobiliaria.inmobiliaria_backend.repository.PropiedadRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PropiedadService {

    private final PropiedadRepository propiedadRepository;
    private final PropiedadMapper propiedadMapper;

    public PropiedadDTO crearPropiedad(PropiedadDTO propiedadDTO) {
        var propiedadEntidad = propiedadMapper.toEntity(propiedadDTO);
        var propiedadGuardada = propiedadRepository.save(propiedadEntidad);
        return propiedadMapper.toDTO(propiedadGuardada);
    }

    public List<PropiedadDTO> listar(){
        return propiedadRepository.findAll()
                .stream()
                .map(propiedadMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PropiedadDTO obtenerPorId(Long id) {
        Propiedad propiedad = propiedadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Propiedad no encontrada"));
        return propiedadMapper.toDTO(propiedad);
    }

    public PropiedadDTO actualizar(Long id, PropiedadDTO dto) {
        Propiedad propiedad = propiedadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Propiedad no encontrada"));

        propiedad.setTitulo(dto.getTitulo());
        propiedad.setDescripcion(dto.getDescripcion());
        propiedad.setPrecio(dto.getPrecio());
        propiedad.setMetrosCuadrados(dto.getMetrosCuadrados());
        propiedad.setDireccion(dto.getDireccion());
        propiedad.setDistrito(dto.getDistrito());
        propiedad.setTipo(dto.getTipo());
        propiedad.setEstado(dto.getEstado());
        propiedad.setImagenUrl(dto.getImagenUrl());
        propiedad.setServicios(dto.getServicios());

        Propiedad actualizada = propiedadRepository.save(propiedad);
        return propiedadMapper.toDTO(actualizada);
    }

    public void eliminar(Long id) {
        Propiedad propiedad = propiedadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Propiedad no encontrada"));
        propiedadRepository.deleteById(id);
    }


}

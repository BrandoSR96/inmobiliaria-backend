package com.inmobiliaria.inmobiliaria_backend.mapper;

import com.inmobiliaria.inmobiliaria_backend.dto.PropiedadDTO;
import com.inmobiliaria.inmobiliaria_backend.dto.UsuarioDTO;
import com.inmobiliaria.inmobiliaria_backend.model.Propiedad;
import com.inmobiliaria.inmobiliaria_backend.model.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    public UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setEmail(usuario.getEmail());
        dto.setPassword(usuario.getPassword());
        dto.setRol(usuario.getRol() != null ? usuario.getRol() : null);

        List<PropiedadResumenDTO> propiedades = usuario.getPropiedades() != null
                ? usuario.getPropiedades().stream()
                .map(this::toResumenPropiedad)
                .collect(Collectors.toList())
                : null;

        dto.setPropiedades(propiedades);

        return dto;
    }

    public Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        usuario.setRol(dto.getRol() != null ? dto.getRol() : null);
        return usuario;
    }

    private PropiedadDTO toDTOPropiedad(Propiedad propiedad) {
        PropiedadDTO dto = new PropiedadDTO();
        dto.setId(propiedad.getId());
        dto.setTitulo(propiedad.getTitulo());
        dto.setDescripcion(propiedad.getDescripcion());
        dto.setPrecio(propiedad.getPrecio());
        dto.setMetrosCuadrados(propiedad.getMetrosCuadrados());
        dto.setDireccion(propiedad.getDireccion());
        dto.setDistrito(propiedad.getDistrito());
        dto.setTipo(propiedad.getTipo());
        dto.setEstado(propiedad.getEstado());
        dto.setServicios(propiedad.getServicios());
        dto.setFechaPublicacion(propiedad.getFechaPublicacion().toString());
        return dto;
    }

    private PropiedadResumenDTO toResumenPropiedad(Propiedad propiedad) {
        PropiedadResumenDTO dto = new PropiedadResumenDTO();
        dto.setId(propiedad.getId());
        dto.setTitulo(propiedad.getTitulo());
        dto.setDescripcion(propiedad.getDescripcion());
        dto.setPrecio(propiedad.getPrecio());
        dto.setMetrosCuadrados(propiedad.getMetrosCuadrados());
        dto.setDireccion(propiedad.getDireccion());
        dto.setDistrito(propiedad.getDistrito());
        dto.setTipo(propiedad.getTipo());
        dto.setEstado(propiedad.getEstado());
        dto.setServicios(propiedad.getServicios());
        dto.setFechaPublicacion(propiedad.getFechaPublicacion());
        return dto;
    }


}

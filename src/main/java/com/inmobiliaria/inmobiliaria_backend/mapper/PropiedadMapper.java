package com.inmobiliaria.inmobiliaria_backend.mapper;

import com.inmobiliaria.inmobiliaria_backend.dto.PropiedadDTO;
import com.inmobiliaria.inmobiliaria_backend.dto.UsuarioDTO;
import com.inmobiliaria.inmobiliaria_backend.model.Propiedad;
import com.inmobiliaria.inmobiliaria_backend.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class PropiedadMapper {
    public Propiedad toEntity(PropiedadDTO dto) {
        if (dto == null) return null;

        Propiedad propiedad = new Propiedad();
        propiedad.setId(dto.getId());
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

        if (dto.getUsuario() != null && dto.getUsuario().getId() != null) {
            Usuario usuario = new Usuario();
            usuario.setId(dto.getUsuario().getId());
            usuario.setNombre(dto.getUsuario().getNombre());
            usuario.setEmail(dto.getUsuario().getEmail());
            propiedad.setUsuario(usuario);
        }

        return propiedad;
    }

    public PropiedadDTO toDTO(Propiedad entidad) {
        if (entidad == null) return null;

        PropiedadDTO dto = new PropiedadDTO();
        dto.setId(entidad.getId());
        dto.setTitulo(entidad.getTitulo());
        dto.setDescripcion(entidad.getDescripcion());
        dto.setPrecio(entidad.getPrecio());
        dto.setMetrosCuadrados(entidad.getMetrosCuadrados());
        dto.setDireccion(entidad.getDireccion());
        dto.setDistrito(entidad.getDistrito());
        dto.setTipo(entidad.getTipo());
        dto.setEstado(entidad.getEstado());
        dto.setImagenUrl(entidad.getImagenUrl());
        dto.setServicios(entidad.getServicios());


        if (entidad.getUsuario() != null) {
            Usuario usuario = entidad.getUsuario();
            UsuarioResumenDTO usuarioDTO = new UsuarioResumenDTO();
            usuarioDTO.setId(usuario.getId());
            usuarioDTO.setNombre(usuario.getNombre());
            usuarioDTO.setEmail(usuario.getEmail());
            usuarioDTO.setRol(usuario.getRol());
            dto.setUsuario(usuarioDTO);
        }

        if (entidad.getFechaPublicacion() != null) {
            dto.setFechaPublicacion(entidad.getFechaPublicacion().toString());
        }

        return dto;
    }

}

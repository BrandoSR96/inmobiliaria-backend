package com.inmobiliaria.inmobiliaria_backend.service;

import com.inmobiliaria.inmobiliaria_backend.dto.UsuarioDTO;
import com.inmobiliaria.inmobiliaria_backend.mapper.UsuarioMapper;
import com.inmobiliaria.inmobiliaria_backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        var usuarioEntidad = usuarioMapper.toEntity(usuarioDTO);
        var usuarioGuardado = usuarioRepository.save(usuarioEntidad);
        return usuarioMapper.toDTO(usuarioGuardado);
    }

    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toDTO)
                .collect(Collectors.toList());
    }
}

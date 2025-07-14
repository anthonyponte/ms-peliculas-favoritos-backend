package com.anthonyponte.peliculas.favoritos.mapper;

import com.anthonyponte.peliculas.favoritos.dto.UsuarioDTO;
import com.anthonyponte.peliculas.favoritos.entity.Usuario;

public class UsuarioMapper {
    public static UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setUsername(usuario.getUsername());
        dto.setPwd(usuario.getPwd());
        dto.setEstado(usuario.getEstado());

        return dto;
    }

    public static Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setUsername(dto.getUsername());
        usuario.setPwd(dto.getPwd());
        usuario.setEstado(dto.getEstado());

        return usuario;
    }
}

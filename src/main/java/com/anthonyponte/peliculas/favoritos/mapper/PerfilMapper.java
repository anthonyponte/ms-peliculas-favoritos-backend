package com.anthonyponte.peliculas.favoritos.mapper;

import com.anthonyponte.peliculas.favoritos.dto.PerfilDTO;
import com.anthonyponte.peliculas.favoritos.entity.Perfil;

public class PerfilMapper {
    public static PerfilDTO toDTO(Perfil perfil) {
        PerfilDTO dto = new PerfilDTO();
        dto.setId(perfil.getId());
        dto.setDescripcion(perfil.getDescripcion());

        return dto;
    }

    public static Perfil toEntity(PerfilDTO dto) {
        Perfil perfil = new Perfil();
        perfil.setId(dto.getId());
        perfil.setDescripcion(dto.getDescripcion());

        return perfil;
    }
}

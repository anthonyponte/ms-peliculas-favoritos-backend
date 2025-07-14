package com.anthonyponte.peliculas.favoritos.mapper;

import com.anthonyponte.peliculas.favoritos.dto.FavoritoDTO;
import com.anthonyponte.peliculas.favoritos.entity.Favorito;

public class FavoritoMapper {
    public static FavoritoDTO toDTO(Favorito favorito) {
        FavoritoDTO dto = new FavoritoDTO();
        dto.setId(favorito.getId());
        dto.setIdUsuario(favorito.getIdUsuario());
        dto.setIdPelicula(favorito.getIdPelicula());

        return dto;
    }

    public static Favorito toEntity(FavoritoDTO dto) {
        Favorito favorito = new Favorito();
        favorito.setId(dto.getId());
        favorito.setIdUsuario(dto.getIdUsuario());
        favorito.setIdPelicula(dto.getIdPelicula());

        return favorito;
    }
}

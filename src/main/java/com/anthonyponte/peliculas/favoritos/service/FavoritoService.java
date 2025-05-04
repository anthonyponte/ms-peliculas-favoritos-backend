package com.anthonyponte.peliculas.favoritos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anthonyponte.peliculas.favoritos.dto.FavoritoDTO;

@Service
public interface FavoritoService {
    public List<FavoritoDTO> listarFavoritosPorUsuarioId(String usuarioId);

    public void crearFavorito(String usuarioId, Long peliculaId);

    public void eliminarFavorito(String usuarioId, Long peliculaId);
}

package com.anthonyponte.peliculas.favoritos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anthonyponte.peliculas.favoritos.entity.Favorito;

@Service
public interface FavoritoService {
    public List<Favorito> listarFavoritosPorIdUsuario(Long idUsuario);

    public Favorito crearFavorito(Favorito favorito);

    public void eliminarFavoritoPorId(Long id);
}

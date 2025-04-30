package com.anthonyponte.peliculas.favoritos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anthonyponte.peliculas.favoritos.model.Favorito;

@Service
public interface IFavoritoService {
    public List<Favorito> listarTodos(String usuarioId);

    public Favorito guardar(Favorito favorito);

    public void eliminar(Long id);
}

package com.anthonyponte.msfavoritos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anthonyponte.msfavoritos.model.Favorito;

@Service
public interface IFavoritoService {
    public List<Favorito> listarTodos(String usuarioId);

    public Favorito guardar(Favorito favorito);

    public void eliminar(Long id);
}

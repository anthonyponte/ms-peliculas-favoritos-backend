package com.anthonyponte.peliculas.favoritos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anthonyponte.peliculas.favoritos.model.Favorito;
import com.anthonyponte.peliculas.favoritos.repository.FavoritoRepository;

@Component
public class FavoritoServiceImpl implements IFavoritoService {
    @Autowired
    private FavoritoRepository repository;

    @Override
    public List<Favorito> listarTodos() {
        return repository.findAll();
    }

    @Override
    public List<Favorito> listarPorUsuarioId(String usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    @Override
    public Favorito guardar(Favorito favorito) {
        return repository.save(favorito);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

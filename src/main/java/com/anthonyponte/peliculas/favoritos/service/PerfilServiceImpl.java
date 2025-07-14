package com.anthonyponte.peliculas.favoritos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.anthonyponte.peliculas.favoritos.entity.Perfil;
import com.anthonyponte.peliculas.favoritos.repository.PerfilRepository;

@Component
public class PerfilServiceImpl implements PerfilService {
    @Autowired
    private PerfilRepository repository;

    @Override
    public List<Perfil> listarPerfiles() {
        return repository.findAll();
    }

    @Override
    public Perfil obtenerPerfilPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Perfil no encontrado"));
    }

    @Override
    public Perfil crearPerfil(Perfil perfil) {
        return repository.save(perfil);
    }

    @Override
    public Perfil actualizarPerfil(Long id, Perfil perfil) {
        Perfil p = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Perfil no encontrado"));

        p.setDescripcion(perfil.getDescripcion());

        return repository.save(p);
    }

    @Override
    public void eliminarPerfilPorId(Long id) {
        Perfil perfil = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Perfil no encontrado"));

        repository.delete(perfil);
    }
}

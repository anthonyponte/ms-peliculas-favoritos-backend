package com.anthonyponte.peliculas.favoritos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anthonyponte.peliculas.favoritos.entity.Perfil;

@Service
public interface PerfilService {
    public List<Perfil> listarPerfiles();

    public Perfil obtenerPerfilPorId(Long id);

    public Perfil crearPerfil(Perfil perfil);

    public Perfil actualizarPerfil(Long id, Perfil perfil);

    public void eliminarPerfilPorId(Long id);
}

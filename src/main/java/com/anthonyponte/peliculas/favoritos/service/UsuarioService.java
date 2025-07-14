package com.anthonyponte.peliculas.favoritos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anthonyponte.peliculas.favoritos.entity.Usuario;

@Service
public interface UsuarioService {
    public List<Usuario> listarUsuarios();

    public Usuario obtenerUsuarioPorId(Long id);

    public Usuario crearUsuario(Usuario usuario);

    public Usuario actualizarUsuario(Long id, Usuario usuario);

    public void eliminarUsuarioPorId(Long id);
}

package com.anthonyponte.peliculas.favoritos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.anthonyponte.peliculas.favoritos.entity.Usuario;
import com.anthonyponte.peliculas.favoritos.repository.UsuarioRepository;

@Component
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Override
    public List<Usuario> listarUsuarios() {
        return repository.findAll();
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        Usuario u = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

        u.setPwd(usuario.getPwd());
        u.setEstado(usuario.getEstado());

        return repository.save(u);
    }

    @Override
    public void eliminarUsuarioPorId(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

        repository.delete(usuario);
    }
}

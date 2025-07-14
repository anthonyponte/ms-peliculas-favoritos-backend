package com.anthonyponte.peliculas.favoritos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anthonyponte.peliculas.favoritos.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}

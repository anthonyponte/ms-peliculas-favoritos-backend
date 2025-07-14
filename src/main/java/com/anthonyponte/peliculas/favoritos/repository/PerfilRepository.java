package com.anthonyponte.peliculas.favoritos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anthonyponte.peliculas.favoritos.entity.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}

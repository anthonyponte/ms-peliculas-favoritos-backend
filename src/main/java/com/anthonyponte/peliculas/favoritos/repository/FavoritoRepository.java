package com.anthonyponte.peliculas.favoritos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anthonyponte.peliculas.favoritos.model.Favorito;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, Long> {
    public List<Favorito> findByUsuarioId(String usuarioId);
}

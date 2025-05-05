package com.anthonyponte.peliculas.favoritos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anthonyponte.peliculas.favoritos.dto.FavoritoDTO;
import com.anthonyponte.peliculas.favoritos.service.FavoritoService;

@RestController
@RequestMapping("/api/v1/favoritos")
public class FavoritoController {
    @Autowired
    private FavoritoService service;

    @GetMapping
    public ResponseEntity<List<FavoritoDTO>> listarFavoritosPorUsuarioId(@RequestParam String usuarioId) {
        return ResponseEntity.ok(service.listarFavoritosPorUsuarioId(usuarioId));
    }

    @PostMapping("/{usuarioId}/{peliculaId}")
    public ResponseEntity<Void> crearFavorito(@PathVariable String usuarioId, @PathVariable Long peliculaId) {
        service.crearFavorito(usuarioId, peliculaId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{usuarioId}/{peliculaId}")
    public ResponseEntity<Void> eliminarFavorito(@PathVariable String usuarioId, @PathVariable Long peliculaId) {
        service.eliminarFavorito(usuarioId, peliculaId);
        return ResponseEntity.noContent().build();
    }
}

package com.anthonyponte.peliculas.favoritos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anthonyponte.peliculas.favoritos.client.PeliculaFeignClient;
import com.anthonyponte.peliculas.favoritos.model.Favorito;
import com.anthonyponte.peliculas.favoritos.service.IFavoritoService;

@RestController
@RequestMapping("/api/v1/peliculas/favoritos")
public class FavoritoController {
    @Autowired
    private IFavoritoService service;

    @Autowired
    private PeliculaFeignClient client;

    @GetMapping
    public ResponseEntity<List<Favorito>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<Favorito>> listarPorUsuarioId(@PathVariable String usuarioId) {
        return ResponseEntity.ok(service.listarPorUsuarioId(usuarioId));
    }

    @PostMapping
    public ResponseEntity<Favorito> crear(@RequestBody Favorito favorito) {
        if (client.obtenerPeliculaPorId(favorito.getIdPelicula()) != null) {
            return ResponseEntity.ok(service.guardar(favorito));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

package com.anthonyponte.msfavoritos.controller;

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

import com.anthonyponte.msfavoritos.model.Favorito;
import com.anthonyponte.msfavoritos.service.IFavoritoService;

@RestController
@RequestMapping("/favoritos")
public class FavoritoController {
    @Autowired
    private IFavoritoService service;

    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<Favorito>> listarTodos(@PathVariable String usuarioId) {
        return ResponseEntity.ok(service.listarTodos(usuarioId));
    }

    @PostMapping
    public ResponseEntity<Favorito> crear(@RequestBody Favorito favorito) {
        return ResponseEntity.ok(service.guardar(favorito));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

package com.anthonyponte.peliculas.favoritos.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.anthonyponte.peliculas.favoritos.dto.FavoritoDTO;
import com.anthonyponte.peliculas.favoritos.entity.Favorito;
import com.anthonyponte.peliculas.favoritos.mapper.FavoritoMapper;
import com.anthonyponte.peliculas.favoritos.service.FavoritoService;

@RestController
@RequestMapping("/api/v1/favoritos")
public class FavoritoController {
    @Autowired
    private FavoritoService service;

    @GetMapping
    public List<FavoritoDTO> listarFavoritosPorUsuarioId(@RequestParam Long idUsuario) {
        return service.listarFavoritosPorIdUsuario(idUsuario)
                .stream()
                .map(FavoritoMapper::toDTO)
                .toList();
    }

    @PostMapping
    public ResponseEntity<?> crearFavorito(@RequestBody FavoritoDTO favoritoDTO) {
        Favorito favorito = FavoritoMapper.toEntity(favoritoDTO);
        Favorito f = service.crearFavorito(favorito);
        FavoritoDTO dto = FavoritoMapper.toDTO(f);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .build(dto.getId());

        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarFavoritoPorId(@PathVariable Long id) {
        System.out.println("eliminarFavoritoPorId: " + id);
        service.eliminarFavoritoPorId(id);
    }
}

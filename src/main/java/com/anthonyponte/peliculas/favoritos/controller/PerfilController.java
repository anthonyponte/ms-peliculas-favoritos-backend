package com.anthonyponte.peliculas.favoritos.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.anthonyponte.peliculas.favoritos.dto.PerfilDTO;
import com.anthonyponte.peliculas.favoritos.entity.Perfil;
import com.anthonyponte.peliculas.favoritos.mapper.PerfilMapper;
import com.anthonyponte.peliculas.favoritos.service.PerfilService;

@RestController
@RequestMapping("/api/v1/perfiles")
public class PerfilController {
    @Autowired
    private PerfilService service;

    @GetMapping
    public List<PerfilDTO> listarPerfiles() {
        return service.listarPerfiles()
                .stream()
                .map(PerfilMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilDTO> obtenerPerfilPorId(@PathVariable Long id) {
        Perfil perfil = service.obtenerPerfilPorId(id);
        PerfilDTO dto = PerfilMapper.toDTO(perfil);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<?> crearPerfil(@RequestBody PerfilDTO perfilDTO) {
        Perfil perfil = PerfilMapper.toEntity(perfilDTO);
        Perfil p = service.crearPerfil(perfil);
        PerfilDTO dto = PerfilMapper.toDTO(p);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .build(p.getId());

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PerfilDTO> actualizarPerfil(@PathVariable Long id, @RequestBody PerfilDTO perfilDTO) {
        Perfil perfil = PerfilMapper.toEntity(perfilDTO);
        Perfil p = service.actualizarPerfil(id, perfil);
        PerfilDTO dto = PerfilMapper.toDTO(p);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarPerfilPorId(@PathVariable Long id) {
        service.eliminarPerfilPorId(id);
    }
}

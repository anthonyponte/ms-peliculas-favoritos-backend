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

import com.anthonyponte.peliculas.favoritos.dto.UsuarioDTO;
import com.anthonyponte.peliculas.favoritos.entity.Usuario;
import com.anthonyponte.peliculas.favoritos.mapper.UsuarioMapper;
import com.anthonyponte.peliculas.favoritos.service.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<UsuarioDTO> listarUsuarios() {
        return service.listarUsuarios()
                .stream()
                .map(UsuarioMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtenerUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = service.obtenerUsuarioPorId(id);
        UsuarioDTO dto = UsuarioMapper.toDTO(usuario);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioMapper.toEntity(usuarioDTO);
        Usuario u = service.crearUsuario(usuario);
        UsuarioDTO dto = UsuarioMapper.toDTO(u);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .build(u.getId());

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioMapper.toEntity(usuarioDTO);
        Usuario u = service.actualizarUsuario(id, usuario);
        UsuarioDTO dto = UsuarioMapper.toDTO(u);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuarioPorId(@PathVariable Long id) {
        service.eliminarUsuarioPorId(id);
    }
}

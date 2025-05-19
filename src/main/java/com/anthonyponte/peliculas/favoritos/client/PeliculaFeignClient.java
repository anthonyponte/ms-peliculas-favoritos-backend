package com.anthonyponte.peliculas.favoritos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.anthonyponte.peliculas.favoritos.dto.PeliculaDTO;

@FeignClient(name = "ms-peliculas-backend")
public interface PeliculaFeignClient {
    @GetMapping("/api/v1/peliculas/{id}")
    PeliculaDTO obtenerPeliculaPorId(@PathVariable Long id);

    @PatchMapping("/api/v1/peliculas/{id}/favoritos")
    void actualizarPeliculaFavorito(@PathVariable Long id, @RequestParam boolean esFavorito);
}

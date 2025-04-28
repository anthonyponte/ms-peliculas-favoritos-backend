package com.anthonyponte.msfavoritos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.anthonyponte.msfavoritos.model.Pelicula;

@FeignClient(name = "ms-peliculas", url = "${ms-peliculas.url}")
public interface PeliculaFeignClient {
    @GetMapping("/peliculas/{id}")
    Pelicula obtenerPeliculaPorId(@PathVariable Long id);
}

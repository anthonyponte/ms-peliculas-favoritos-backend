package com.anthonyponte.peliculas.favoritos.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-peliculas-backend")
public interface PeliculaFeignClient {
    @GetMapping("/api/v1/peliculas/existe/{id}")
    boolean existePeliculaPorId(@PathVariable Long id);
}

package com.anthonyponte.peliculas.favoritos.service;

import com.anthonyponte.peliculas.favoritos.dto.PeliculaDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PeliculaService {
    @GET("/api/v1/peliculas/{id}")
    Call<PeliculaDTO> obtenerPeliculaPorId(@Path("id") Long id);

    @PATCH("/api/v1/peliculas/{id}/favoritos")
    Call<Void> actualizarPeliculaFavorito(@Path("id") Long id, @Query("esFavorito") boolean esFavorito);
}

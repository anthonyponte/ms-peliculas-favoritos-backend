package com.anthonyponte.peliculas.favoritos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.anthonyponte.peliculas.favoritos.entity.Favorito;
import com.anthonyponte.peliculas.favoritos.feign.PeliculaFeignClient;
import com.anthonyponte.peliculas.favoritos.repository.FavoritoRepository;

@Component
public class FavoritoServiceImpl implements FavoritoService {
    @Autowired
    private FavoritoRepository repository;

    @Autowired
    private PeliculaFeignClient client;

    @Override
    public List<Favorito> listarFavoritosPorIdUsuario(Long idUsuario) {
        return repository.findAllByIdUsuario(idUsuario);
    }

    @Override
    public Favorito crearFavorito(Favorito favorito) {
        boolean existe = client.existePeliculaPorId(favorito.getIdPelicula());

        if (!existe) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pelicula no encontrada");
        }

        Favorito f = repository.save(favorito);

        return f;
    }

    @Override
    public void eliminarFavoritoPorId(Long id) {
        Favorito favorito = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Favorito no encontrado"));

        repository.delete(favorito);
    }

    @Override
    public void eliminarFavoritoPorIdPelicula(Long idPelicula) {
        List<Favorito> listFavoritos = repository.findAllByIdPelicula(idPelicula);
        repository.deleteAllInBatch(listFavoritos);
    }
}

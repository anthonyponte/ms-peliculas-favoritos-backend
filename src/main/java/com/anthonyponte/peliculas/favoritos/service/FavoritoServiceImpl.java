package com.anthonyponte.peliculas.favoritos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anthonyponte.peliculas.favoritos.client.PeliculaRetrofitClient;
import com.anthonyponte.peliculas.favoritos.dto.FavoritoDTO;
import com.anthonyponte.peliculas.favoritos.entity.Favorito;
import com.anthonyponte.peliculas.favoritos.entity.Pelicula;
import com.anthonyponte.peliculas.favoritos.repository.FavoritoRepository;

@Component
public class FavoritoServiceImpl implements FavoritoService {
    @Autowired
    private FavoritoRepository repository;

    @Override
    public List<FavoritoDTO> listarFavoritosPorUsuarioId(String usuarioId) {
        List<Favorito> listFavoritos = repository.findAll();
        return listFavoritos.stream()
                .map(this::convertirAFavoritoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void crearFavorito(String usuarioId, Long peliculaId) {
        FavoritoDTO favoritoDTO = new FavoritoDTO();
        favoritoDTO.setUsuarioId(usuarioId);
        favoritoDTO.setPeliculaId(peliculaId);

        Favorito favorito = convertirAFavorito(favoritoDTO);
        repository.save(favorito);

        try {
            PeliculaRetrofitClient.getPeliculaService().actualizarPeliculaFavorito(peliculaId, true).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarFavorito(String usuarioId, Long peliculaId) {
        FavoritoDTO favoritoDTO = new FavoritoDTO();
        favoritoDTO.setUsuarioId(usuarioId);
        favoritoDTO.setPeliculaId(peliculaId);

        Favorito favorito = convertirAFavorito(favoritoDTO);
        repository.delete(favorito);

        try {
            PeliculaRetrofitClient.getPeliculaService().actualizarPeliculaFavorito(peliculaId, false).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private FavoritoDTO convertirAFavoritoDTO(Favorito favorito) {
        FavoritoDTO dto = new FavoritoDTO();
        dto.setId(favorito.getId());
        dto.setUsuarioId(favorito.getUsuarioId());
        dto.setPeliculaId(favorito.getPelicula().getId());
        dto.setPeliculaTitulo(favorito.getPelicula().getTitulo());
        return dto;
    }

    private Favorito convertirAFavorito(FavoritoDTO dto) {
        Favorito favorito = new Favorito();
        favorito.setId(dto.getId());
        favorito.setUsuarioId(dto.getUsuarioId());

        Pelicula pelicula = new Pelicula();
        pelicula.setId(dto.getPeliculaId());
        favorito.setPelicula(pelicula);

        return favorito;
    }
}

package com.anthonyponte.msfavoritos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "favoritos")
public class Favorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String usuario;

    @Column(nullable = false)
    private Long idPelicula;

    public Favorito() {
    }

    public Favorito(Long id, String usuario, Long idPelicula) {
        this.id = id;
        this.usuario = usuario;
        this.idPelicula = idPelicula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    @Override
    public String toString() {
        return "Favorito [id=" + id + ", usuario=" + usuario + ", idPelicula=" + idPelicula + "]";
    }
}

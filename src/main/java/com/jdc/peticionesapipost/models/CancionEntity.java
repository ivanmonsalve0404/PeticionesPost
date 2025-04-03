package com.jdc.peticionesapipost.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "canciones")
public class CancionEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcancion")
    private Long idcancion;

    @NotNull
    @Column(name = "album", length = 250)
    private String album;

    @NotNull
    @Column(name = "duracion")
    private LocalTime duracion;

    @NotNull
    @Column(name = "fecha_lanzamiento")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fecha_lanzamiento;

    @NotNull
    @Column(name = "nombre", length = 250)
    private String nombre;

    @NotNull
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fkgenero")
    private GeneroEntity genero;

    // Getter personalizado
    @JsonProperty("fkgenero")
    public Long getIdgenero() {
        return genero != null ? genero.getIdgenero() : null;
    }

    public Long getIdcancion() {
        return idcancion;
    }

    public void setIdcancion(Long idcancion) {
        this.idcancion = idcancion;
    }

    public @NotNull String getAlbum() {
        return album;
    }

    public void setAlbum(@NotNull String album) {
        this.album = album;
    }

    public @NotNull LocalTime getDuracion() {
        return duracion;
    }

    public void setDuracion(@NotNull LocalTime duracion) {
        this.duracion = duracion;
    }

    public @NotNull Date getFecha_lanzamiento() {
        return fecha_lanzamiento;
    }

    public void setFecha_lanzamiento(@NotNull Date fecha_lanzamiento) {
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    public @NotNull String getNombre() {
        return nombre;
    }

    public void setNombre(@NotNull String nombre) {
        this.nombre = nombre;
    }

    public void setGenero(@NotNull GeneroEntity genero) {
        this.genero = genero;
    }
}

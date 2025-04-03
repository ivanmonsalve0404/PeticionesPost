package com.jdc.peticionesapipost.dto;

import java.time.LocalTime;
import java.util.Date;

public class CancionDTO {

    private String nombre;
    private Date fecha_lanzamiento;
    private LocalTime duracion;
    private String album;
    private Long fkgenero;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_lanzamiento() {
        return fecha_lanzamiento;
    }

    public void setFecha_lanzamiento(Date fecha_lanzamiento) {
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    public LocalTime getDuracion() {
        return duracion;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Long getFkgenero() {
        return fkgenero;
    }

    public void setFkgenero(Long fkgenero) {
        this.fkgenero = fkgenero;
    }
}

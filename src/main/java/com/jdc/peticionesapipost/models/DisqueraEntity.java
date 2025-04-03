package com.jdc.peticionesapipost.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "disqueras")
public class DisqueraEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddisquera")
    private Long iddisquera;

    @NotNull
    @Column(name = "fecha_fundacion")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fecha_fundacion;

    @NotNull
    @Column(name = "nombre", length = 250)
    private String nombre;

    @NotNull
    @Column(name = "pais", length = 250)
    private String pais;

    public Long getIddisquera() {
        return iddisquera;
    }

    public void setIddisquera(Long iddisquera) {
        this.iddisquera = iddisquera;
    }

    public @NotNull Date getFecha_fundacion() {
        return fecha_fundacion;
    }

    public void setFecha_fundacion(@NotNull Date fecha_fundacion) {
        this.fecha_fundacion = fecha_fundacion;
    }

    public @NotNull String getNombre() {
        return nombre;
    }

    public void setNombre(@NotNull String nombre) {
        this.nombre = nombre;
    }

    public @NotNull String getPais() {
        return pais;
    }

    public void setPais(@NotNull String pais) {
        this.pais = pais;
    }
}

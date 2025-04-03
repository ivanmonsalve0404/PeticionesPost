package com.jdc.peticionesapipost.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "artistas")
public class ArtistaEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idartista")
    private Long idartista;

    @NotNull
    @Column(name = "apellidos", length = 250)
    private String apellidos;

    @NotNull
    @Column(name = "nombres", length = 250)
    private String nombres;

    @NotNull
    @Column(name = "fecha_nacimiento")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fecha_nacimiento;

    @NotNull
    @Column(name = "nacionalidad", length = 150)
    private String nacionalidad;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkdisquera", referencedColumnName = "iddisquera")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private DisqueraEntity disquera;

    @JsonProperty("fkdisquera")
    public Long getIddisquera() {
        return disquera != null ? disquera.getIddisquera() : null;
    }

    public Long getIdartista() {
        return idartista;
    }

    public void setIdartista(Long idartista) {
        this.idartista = idartista;
    }

    public @NotNull String getApellidos() {
        return apellidos;
    }

    public void setApellidos(@NotNull String apellidos) {
        this.apellidos = apellidos;
    }

    public @NotNull String getNombres() {
        return nombres;
    }

    public void setNombres(@NotNull String nombres) {
        this.nombres = nombres;
    }

    public @NotNull Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(@NotNull Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public @NotNull String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(@NotNull String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setDisquera(@NotNull DisqueraEntity disquera) {
        this.disquera = disquera;
    }
}

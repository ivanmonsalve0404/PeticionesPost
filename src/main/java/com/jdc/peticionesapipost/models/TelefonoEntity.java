package com.jdc.peticionesapipost.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "telefonos")
public class TelefonoEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtelefono")
    private Long iddisquera;

    @NotNull
    @Column(name = "numero", length = 250)
    private String numero;

    @NotNull
    @Column(name = "tipo")
    private Integer tipo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkartista", referencedColumnName = "idartista")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ArtistaEntity artista;

    @JsonProperty("fkartista")
    public Long getIdartista() {
        return artista != null ? artista.getIdartista() : null;
    }

    public Long getIddisquera() {
        return iddisquera;
    }

    public void setIddisquera(Long iddisquera) {
        this.iddisquera = iddisquera;
    }

    public @NotNull String getNumero() {
        return numero;
    }

    public void setNumero(@NotNull String numero) {
        this.numero = numero;
    }

    public @NotNull Integer getTipo() {
        return tipo;
    }

    public void setTipo(@NotNull Integer tipo) {
        this.tipo = tipo;
    }

    public void setArtista(@NotNull ArtistaEntity artista) {
        this.artista = artista;
    }
}

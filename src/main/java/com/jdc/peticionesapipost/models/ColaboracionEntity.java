package com.jdc.peticionesapipost.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jdc.peticionesapipost.enums.TipoColaboracion;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "colaboraciones")
public class ColaboracionEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcolaboracion")
    private Long idcolaboracion;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_participacion")
    private TipoColaboracion tipo_participacion;

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

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkcancion", referencedColumnName = "idcancion")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private CancionEntity cancion;

    @JsonProperty("fkcancion")
    public Long getIdcancion() {
        return cancion != null ? cancion.getIdcancion() : null;
    }

    public Long getIdcolaboracion() {
        return idcolaboracion;
    }

    public void setIdcolaboracion(Long idcolaboracion) {
        this.idcolaboracion = idcolaboracion;
    }

    public @NotNull TipoColaboracion getTipo_participacion() {
        return tipo_participacion;
    }

    public void setTipo_participacion(@NotNull TipoColaboracion tipo_participacion) {
        this.tipo_participacion = tipo_participacion;
    }

    public void setArtista(@NotNull ArtistaEntity artista) {
        this.artista = artista;
    }

    public void setCancion(@NotNull CancionEntity cancion) {
        this.cancion = cancion;
    }
}

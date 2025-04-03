package com.jdc.peticionesapipost.service;

import com.jdc.peticionesapipost.dto.ArtistaDTO;
import com.jdc.peticionesapipost.models.ArtistaEntity;

import java.util.List;

public interface IArtistaService {

    public ArtistaEntity save(ArtistaDTO artistaDTO);
    public List<ArtistaEntity> findAll();
}

package com.jdc.peticionesapipost.service;

import com.jdc.peticionesapipost.models.DisqueraEntity;

import java.util.List;

public interface IDisqueraService {

    public DisqueraEntity findById(Long id);
    public void save(DisqueraEntity disquera);
    public List<DisqueraEntity> findAll();
}

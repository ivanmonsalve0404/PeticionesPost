package com.jdc.peticionesapipost.service.implement;

import com.jdc.peticionesapipost.dto.ArtistaDTO;
import com.jdc.peticionesapipost.models.ArtistaEntity;
import com.jdc.peticionesapipost.models.DisqueraEntity;
import com.jdc.peticionesapipost.repository.ArtistaRepository;
import com.jdc.peticionesapipost.repository.DisqueraRepository;
import com.jdc.peticionesapipost.service.IArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArtistaServiceImplements implements IArtistaService {

    @Autowired
    private ArtistaRepository artistaRepository;

    @Autowired
    private DisqueraRepository disqueraRepository;

    @Override
    @Transactional
    public ArtistaEntity save(ArtistaDTO artistaDTO) {
        ArtistaEntity artistasaved = new ArtistaEntity();
        DisqueraEntity fkdisquera = disqueraRepository.findById(artistaDTO.getDisquera()).
                orElse(null);

        artistasaved.setNombres(artistaDTO.getNombres());
        artistasaved.setApellidos(artistaDTO.getApellidos());
        artistasaved.setFecha_nacimiento(artistaDTO.getFecha_nacimiento());
        artistasaved.setNacionalidad(artistaDTO.getNacionalidad());
        artistasaved.setDisquera(fkdisquera);
        return artistaRepository.save(artistasaved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ArtistaEntity> findAll() {
        return artistaRepository.findAll();
    }
}

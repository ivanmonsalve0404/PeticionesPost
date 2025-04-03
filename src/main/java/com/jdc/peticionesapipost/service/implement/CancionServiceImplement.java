package com.jdc.peticionesapipost.service.implement;

import com.jdc.peticionesapipost.dto.CancionDTO;
import com.jdc.peticionesapipost.models.CancionEntity;
import com.jdc.peticionesapipost.models.GeneroEntity;
import com.jdc.peticionesapipost.repository.CancionRepository;
import com.jdc.peticionesapipost.repository.GeneroRepository;
import com.jdc.peticionesapipost.service.ICancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CancionServiceImplement implements ICancionService {

    @Autowired
    private CancionRepository cancionRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    @Transactional
    public CancionEntity save(CancionDTO cancionDTO) {

        CancionEntity cancionEntity = new CancionEntity();

        // Mapear el DTO a la entidad
        cancionEntity.setNombre(cancionDTO.getNombre());
        cancionEntity.setFecha_lanzamiento(cancionDTO.getFecha_lanzamiento());
        cancionEntity.setDuracion(cancionDTO.getDuracion());
        cancionEntity.setAlbum(cancionDTO.getAlbum());

        // Asignar la entidad de género usando el id proporcionado
        GeneroEntity genero = generoRepository.findById(cancionDTO.getFkgenero())
                .orElseThrow(()-> new RuntimeException("Género no encontrado"));
        cancionEntity.setGenero(genero);

        // Guardar la entidad en base de datos
        return  cancionRepository.save(cancionEntity);
    }
}

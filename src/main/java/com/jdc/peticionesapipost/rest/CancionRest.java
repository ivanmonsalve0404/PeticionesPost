package com.jdc.peticionesapipost.rest;


import com.jdc.peticionesapipost.dto.ArtistaDTO;
import com.jdc.peticionesapipost.dto.CancionDTO;
import com.jdc.peticionesapipost.models.ArtistaEntity;
import com.jdc.peticionesapipost.models.CancionEntity;
import com.jdc.peticionesapipost.repository.CancionRepository;
import com.jdc.peticionesapipost.service.ICancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cancion")
public class CancionRest {

    @Autowired
    private ICancionService cancionService;

    @PostMapping("/crear")
    public ResponseEntity<CancionEntity> create(
            @RequestBody CancionDTO cancionDTO
    ){
        CancionEntity micancion = cancionService.save(cancionDTO);
        return ResponseEntity.ok(micancion);
    }
}

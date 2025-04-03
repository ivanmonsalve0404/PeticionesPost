package com.jdc.peticionesapipost.rest;

import com.jdc.peticionesapipost.models.ArtistaEntity;
import com.jdc.peticionesapipost.models.DisqueraEntity;
import com.jdc.peticionesapipost.service.IDisqueraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disquera")
public class DisqueraRest {

    @Autowired
    private IDisqueraService disqueraService;

    @PostMapping("/crear")
    public ResponseEntity<DisqueraEntity> crear(
            @RequestBody DisqueraEntity disqueraEntity
    ){
        disqueraService.save(disqueraEntity);
        return ResponseEntity.ok(disqueraEntity);
    }

    @GetMapping("/list")
    private ResponseEntity<List<DisqueraEntity>> list(){
        return ResponseEntity.ok(disqueraService.findAll());
    }
}

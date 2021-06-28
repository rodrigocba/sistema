package com.birra.sistema.controller;


import com.birra.sistema.entity.UnidadDeMedida;
import com.birra.sistema.entity.Fabrica;
import com.birra.sistema.service.UnidadDeMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidadDeMedida")
public class UnidadDeMedidaController {
    private final UnidadDeMedidaService unidadDeMedidaService;

    @Autowired
    public UnidadDeMedidaController(UnidadDeMedidaService unidadDeMedidaService) {
        this.unidadDeMedidaService = unidadDeMedidaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UnidadDeMedida>> getAllUnidadDeMedidas () {
        List<UnidadDeMedida> unidadDeMedidas = unidadDeMedidaService.findAllUnidadDeMedidas();
        return ResponseEntity.ok(unidadDeMedidas);
    }

    @GetMapping("/findbyId/{id}")
    public ResponseEntity<UnidadDeMedida> getUnidadDeMedidaById (@PathVariable("id") Long id) {
        UnidadDeMedida unidadDeMedida = unidadDeMedidaService.findUnidadDeMedidaById(id);
        return new ResponseEntity<>(unidadDeMedida, HttpStatus.OK);
    }

    @GetMapping("/findByNombre/{nombre}")
    public ResponseEntity<UnidadDeMedida> getUnidadDeMedidaByNombre (@PathVariable("nombre") String nombre) {
        UnidadDeMedida unidadDeMedida = unidadDeMedidaService.findUnidadDeMedidaByNombre(nombre);
        return new ResponseEntity<>(unidadDeMedida, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<UnidadDeMedida> addUnidadDeMedida(@RequestBody UnidadDeMedida unidadDeMedida) {
        UnidadDeMedida newUnidadDeMedida = unidadDeMedidaService.addUnidadDeMedida(unidadDeMedida);
        return new ResponseEntity<>(newUnidadDeMedida, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<UnidadDeMedida> updateUnidadDeMedida(@RequestBody UnidadDeMedida unidadDeMedida) {
        UnidadDeMedida updateUnidadDeMedida = unidadDeMedidaService.updateUnidadDeMedida(unidadDeMedida);
        return new ResponseEntity<>(updateUnidadDeMedida, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUnidadDeMedida(@PathVariable("id") Long id) {
        unidadDeMedidaService.deleteUnidadDeMedida(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

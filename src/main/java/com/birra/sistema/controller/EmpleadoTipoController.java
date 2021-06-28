package com.birra.sistema.controller;

import com.birra.sistema.entity.EmpleadoTipo;
import com.birra.sistema.service.EmpleadoTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/empleadoTipo")
public class EmpleadoTipoController {
    private final EmpleadoTipoService empleadoTipoService;

    @Autowired
    public EmpleadoTipoController(EmpleadoTipoService empleadoTipoService) {
        this.empleadoTipoService = empleadoTipoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmpleadoTipo>> getAllEmpleadoTipos () {
        List<EmpleadoTipo> empleadoTipos = empleadoTipoService.findAllEmpleadoTipos();
        return ResponseEntity.ok(empleadoTipos);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<EmpleadoTipo> getEmpleadoTipoById (@PathVariable("id") Long id) {
        EmpleadoTipo empleadoTipo = empleadoTipoService.findEmpleadoTipoById(id);
        return new ResponseEntity<>(empleadoTipo, HttpStatus.OK);
    }

    @GetMapping("/find/{nombre}")
    public ResponseEntity<EmpleadoTipo> getEmpleadoTipoByNombre (@PathVariable("nombre") String nombre) {
        EmpleadoTipo empleadoTipo = empleadoTipoService.findEmpleadoTipoByNombre(nombre);
        return new ResponseEntity<>(empleadoTipo, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<EmpleadoTipo> addEmpleadoTipo(@RequestBody EmpleadoTipo empleadoTipo) {
        EmpleadoTipo newEmpleadoTipo = empleadoTipoService.addEmpleadoTipo(empleadoTipo);
        return new ResponseEntity<>(newEmpleadoTipo, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<EmpleadoTipo> updateEmpleadoTipo(@RequestBody EmpleadoTipo empleadoTipo) {
        EmpleadoTipo updateEmpleadoTipo = empleadoTipoService.updateEmpleadoTipo(empleadoTipo);
        return new ResponseEntity<>(updateEmpleadoTipo, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmpleadoTipo(@PathVariable("id") Long id) {
        empleadoTipoService.deleteEmpleadoTipo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

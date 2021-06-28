package com.birra.sistema.controller;


import com.birra.sistema.entity.Empleado;
import com.birra.sistema.entity.Fabrica;
import com.birra.sistema.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Empleado>> getAllEmpleados () {
        List<Empleado> empleados = empleadoService.findAllEmpleados();
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/findbyId/{id}")
    public ResponseEntity<Empleado> getEmpleadoById (@PathVariable("id") Long id) {
        Empleado empleado = empleadoService.findEmpleadoById(id);
        return new ResponseEntity<>(empleado, HttpStatus.OK);
    }

    @GetMapping("/findByNombre/{nombre}")
    public ResponseEntity<Empleado> getEmpleadoByNombre (@PathVariable("nombre") String nombre) {
        Empleado empleado = empleadoService.findEmpleadoByNombre(nombre);
        return new ResponseEntity<>(empleado, HttpStatus.OK);
    }

    @GetMapping("/findByfabrica/{fabricaId}")
    public ResponseEntity<Empleado> getEmpleadoByFabrica (@PathVariable("fabricaId") Long id) {
        Fabrica f = new Fabrica();
        f.setId(id);
        Empleado empleado = empleadoService.findEmpleadoByFabrica(f);
        return new ResponseEntity<>(empleado, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Empleado> addEmpleado(@RequestBody Empleado empleado) {
        Empleado newEmpleado = empleadoService.addEmpleado(empleado);
        return new ResponseEntity<>(newEmpleado, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Empleado> updateEmpleado(@RequestBody Empleado empleado) {
        Empleado updateEmpleado = empleadoService.updateEmpleado(empleado);
        return new ResponseEntity<>(updateEmpleado, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmpleado(@PathVariable("id") Long id) {
        empleadoService.deleteEmpleado(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.birra.sistema.controller;


import com.birra.sistema.entity.Proveedor;

import com.birra.sistema.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
    private final ProveedorService proveedorService;

    @Autowired
    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Proveedor>> getAllProveedors () {
        List<Proveedor> proveedors = proveedorService.findAllProveedors();
        return ResponseEntity.ok(proveedors);
    }

    @GetMapping("/findbyId/{id}")
    public ResponseEntity<Proveedor> getProveedorById (@PathVariable("id") Long id) {
        Proveedor proveedor = proveedorService.findProveedorById(id);
        return new ResponseEntity<>(proveedor, HttpStatus.OK);
    }

    @GetMapping("/findByNombre/{nombre}")
    public ResponseEntity<Proveedor> getProveedorByNombre (@PathVariable("nombre") String nombre) {
        Proveedor proveedor = proveedorService.findProveedorByNombre(nombre);
        return new ResponseEntity<>(proveedor, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<Proveedor> addProveedor(@RequestBody Proveedor proveedor) {
        Proveedor newProveedor = proveedorService.addProveedor(proveedor);
        return new ResponseEntity<>(newProveedor, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Proveedor> updateProveedor(@RequestBody Proveedor proveedor) {
        Proveedor updateProveedor = proveedorService.updateProveedor(proveedor);
        return new ResponseEntity<>(updateProveedor, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProveedor(@PathVariable("id") Long id) {
        proveedorService.deleteProveedor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.birra.sistema.controller;


import com.birra.sistema.entity.ProductoInsumoDetalle;

import com.birra.sistema.service.ProductoInsumoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productoInsumoDetalle")
public class ProductoInsumoDetalleController {
    private final ProductoInsumoDetalleService productoInsumoDetalleService;

    @Autowired
    public ProductoInsumoDetalleController(ProductoInsumoDetalleService productoInsumoDetalleService) {
        this.productoInsumoDetalleService = productoInsumoDetalleService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductoInsumoDetalle>> getAllProductoInsumoDetalles () {
        List<ProductoInsumoDetalle> productoInsumoDetalles = productoInsumoDetalleService.findAllProductoInsumoDetalles();
        return ResponseEntity.ok(productoInsumoDetalles);
    }

    @GetMapping("/findbyId/{id}")
    public ResponseEntity<ProductoInsumoDetalle> getProductoInsumoDetalleById (@PathVariable("id") Long id) {
        ProductoInsumoDetalle productoInsumoDetalle = productoInsumoDetalleService.findProductoInsumoDetalleById(id);
        return new ResponseEntity<>(productoInsumoDetalle, HttpStatus.OK);
    }





    @PostMapping("/add")
    public ResponseEntity<ProductoInsumoDetalle> addProductoInsumoDetalle(@RequestBody ProductoInsumoDetalle productoInsumoDetalle) {
        ProductoInsumoDetalle newProductoInsumoDetalle = productoInsumoDetalleService.addProductoInsumoDetalle(productoInsumoDetalle);
        return new ResponseEntity<>(newProductoInsumoDetalle, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ProductoInsumoDetalle> updateProductoInsumoDetalle(@RequestBody ProductoInsumoDetalle productoInsumoDetalle) {
        ProductoInsumoDetalle updateProductoInsumoDetalle = productoInsumoDetalleService.updateProductoInsumoDetalle(productoInsumoDetalle);
        return new ResponseEntity<>(updateProductoInsumoDetalle, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProductoInsumoDetalle(@PathVariable("id") Long id) {
        productoInsumoDetalleService.deleteProductoInsumoDetalle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.birra.sistema.controller;
import com.birra.sistema.entity.ProductoInsumo;
import com.birra.sistema.service.ProductoInsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/productoInsumo")
public class ProductoInsumoController {
    private final ProductoInsumoService productoInsumoService;

    @Autowired
    public ProductoInsumoController(ProductoInsumoService productoInsumoService) {
        this.productoInsumoService = productoInsumoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductoInsumo>> getAllProductoInsumos () {
        List<ProductoInsumo> productoInsumos = productoInsumoService.findAllProductoInsumos();
        return ResponseEntity.ok(productoInsumos);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ProductoInsumo> getProductoInsumoById (@PathVariable("id") Long id) {
        ProductoInsumo productoInsumo = productoInsumoService.findProductoInsumoById(id);
        return new ResponseEntity<>(productoInsumo, HttpStatus.OK);
    }

    @GetMapping("/find/{nombre}")
    public ResponseEntity<ProductoInsumo> getProductoInsumoByNombre (@PathVariable("nombre") String nombre) {
        ProductoInsumo productoInsumo = productoInsumoService.findProductoInsumoByNombre(nombre);
        return new ResponseEntity<>(productoInsumo, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ProductoInsumo> addProductoInsumo(@RequestBody ProductoInsumo productoInsumo) {
        ProductoInsumo newProductoInsumo = productoInsumoService.addProductoInsumo(productoInsumo);
        return new ResponseEntity<>(newProductoInsumo, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ProductoInsumo> updateProductoInsumo(@RequestBody ProductoInsumo productoInsumo) {
        ProductoInsumo updateProductoInsumo = productoInsumoService.updateProductoInsumo(productoInsumo);
        return new ResponseEntity<>(updateProductoInsumo, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProductoInsumo(@PathVariable("id") Long id) {
        productoInsumoService.deleteProductoInsumo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

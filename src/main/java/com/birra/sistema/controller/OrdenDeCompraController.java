package com.birra.sistema.controller;
import com.birra.sistema.entity.OrdenDeCompra;
import com.birra.sistema.service.OrdenDeCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/ordenDeCompra")
public class OrdenDeCompraController {
    private final OrdenDeCompraService ordenDeCompraService;

    @Autowired
    public OrdenDeCompraController(OrdenDeCompraService ordenDeCompraService) {
        this.ordenDeCompraService = ordenDeCompraService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrdenDeCompra>> getAllOrdenDeCompras () {
        List<OrdenDeCompra> ordenDeCompras = ordenDeCompraService.findAllOrdenDeCompras();
        return ResponseEntity.ok(ordenDeCompras);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<OrdenDeCompra> getOrdenDeCompraById (@PathVariable("id") Long id) {
        OrdenDeCompra ordenDeCompra = ordenDeCompraService.findOrdenDeCompraById(id);
        return new ResponseEntity<>(ordenDeCompra, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<OrdenDeCompra> addOrdenDeCompra(@RequestBody OrdenDeCompra ordenDeCompra) {
        OrdenDeCompra newOrdenDeCompra = ordenDeCompraService.addOrdenDeCompra(ordenDeCompra);

        return new ResponseEntity<>(newOrdenDeCompra, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<OrdenDeCompra> updateOrdenDeCompra(@RequestBody OrdenDeCompra ordenDeCompra) {
        OrdenDeCompra updateOrdenDeCompra = ordenDeCompraService.updateOrdenDeCompra(ordenDeCompra);
        return new ResponseEntity<>(updateOrdenDeCompra, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrdenDeCompra(@PathVariable("id") Long id) {
        ordenDeCompraService.deleteOrdenDeCompra(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

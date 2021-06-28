package com.birra.sistema.controller;
import com.birra.sistema.entity.Insumo;
import com.birra.sistema.service.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/insumo")
public class InsumoController {
    private final InsumoService insumoService;

    @Autowired
    public InsumoController(InsumoService insumoService) {
        this.insumoService = insumoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Insumo>> getAllInsumos () {
        List<Insumo> insumos = insumoService.findAllInsumos();
        return ResponseEntity.ok(insumos);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Insumo> getInsumoById (@PathVariable("id") Long id) {
        Insumo insumo = insumoService.findInsumoById(id);
        return new ResponseEntity<>(insumo, HttpStatus.OK);
    }

    @GetMapping("/find/{nombre}")
    public ResponseEntity<Insumo> getInsumoByNombre (@PathVariable("nombre") String nombre) {
        Insumo insumo = insumoService.findInsumoByNombre(nombre);
        return new ResponseEntity<>(insumo, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Insumo> addInsumo(@RequestBody Insumo insumo) {
        Insumo newInsumo = insumoService.addInsumo(insumo);
        return new ResponseEntity<>(newInsumo, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Insumo> updateInsumo(@RequestBody Insumo insumo) {
        Insumo updateInsumo = insumoService.updateInsumo(insumo);
        return new ResponseEntity<>(updateInsumo, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteInsumo(@PathVariable("id") Long id) {
        insumoService.deleteInsumo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

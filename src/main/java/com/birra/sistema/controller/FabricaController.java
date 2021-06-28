package com.birra.sistema.controller;
import com.birra.sistema.entity.Fabrica;
import com.birra.sistema.service.FabricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/fabrica")
public class FabricaController {
    private final FabricaService fabricaService;

    @Autowired
    public FabricaController(FabricaService fabricaService) {
        this.fabricaService = fabricaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Fabrica>> getAllFabricas () {
        List<Fabrica> fabricas = fabricaService.findAllFabricas();
        return ResponseEntity.ok(fabricas);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Fabrica> getFabricaById (@PathVariable("id") Long id) {
        Fabrica fabrica = fabricaService.findFabricaById(id);
        return new ResponseEntity<>(fabrica, HttpStatus.OK);
    }

    @GetMapping("/findByName/{nombre}")
    public ResponseEntity<Fabrica> getFabricaByNombre (@PathVariable("nombre") String nombre) {
        Fabrica fabrica = fabricaService.findFabricaByNombre(nombre);
        return new ResponseEntity<>(fabrica, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Fabrica> addFabrica(@RequestBody Fabrica fabrica) {
        Fabrica newFabrica = fabricaService.addFabrica(fabrica);
        return new ResponseEntity<>(newFabrica, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Fabrica> updateFabrica(@RequestBody Fabrica fabrica) {
        Fabrica updateFabrica = fabricaService.updateFabrica(fabrica);
        return new ResponseEntity<>(updateFabrica, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFabrica(@PathVariable("id") Long id) {
        fabricaService.deleteFabrica(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}

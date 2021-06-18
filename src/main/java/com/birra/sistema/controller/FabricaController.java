package com.birra.sistema.controller;
import com.birra.sistema.entity.Fabrica;
import com.birra.sistema.service.FabricaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/fabrica")
public class FabricaController {
    private final FabricaService fabricaService;

    public FabricaController(FabricaService fabricaService) {
        this.fabricaService = fabricaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Fabrica>> getAllEmployees () {
        List<Fabrica> fabricas = fabricaService.findAllFabricas();
        return new ResponseEntity<>(fabricas, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Fabrica> getEmployeeById (@PathVariable("id") Long id) {
        Fabrica fabrica = fabricaService.findFabricaById(id);
        return new ResponseEntity<>(fabrica, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Fabrica> addEmployee(@RequestBody Fabrica fabrica) {
        Fabrica newFabrica = fabricaService.addFabrica(fabrica);
        return new ResponseEntity<>(newFabrica, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Fabrica> updateEmployee(@RequestBody Fabrica fabrica) {
        Fabrica updateFabrica = fabricaService.updateFabrica(fabrica);
        return new ResponseEntity<>(updateFabrica, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        fabricaService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

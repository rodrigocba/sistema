package com.birra.sistema.service;

import com.birra.sistema.entity.Fabrica;
import com.birra.sistema.exception.UserNotFoundException;
import com.birra.sistema.repository.FabricaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;


@Service
@Transactional
public class FabricaService {

   private final FabricaRepo fabricaRepo;

    @Autowired
    public FabricaService(FabricaRepo fabricaRepo) {
        this.fabricaRepo = fabricaRepo;
    }

    public Fabrica addFabrica(Fabrica fabrica) {
       return fabricaRepo.save(fabrica);
    }

    public List<Fabrica> findAllFabricas() {
        return fabricaRepo.findAll();
    }

    public Fabrica updateFabrica(Fabrica fabrica) {

        return fabricaRepo.save(fabrica);
    }

    public Fabrica findFabricaById(Long id) {
        return fabricaRepo.findFabricaById(id)
                .orElseThrow(() -> new UserNotFoundException("Fabrica nro" + id + " no existe"));
    }

    public Fabrica findFabricaByNombre(String name) {
        return fabricaRepo.findFabricaByNombre(name)
                .orElseThrow(() -> new UserNotFoundException("La Fabrica " + name + " no existe"));
    }

    public void deleteFabrica(Long id) {
        fabricaRepo.deleteFabricaById(id);
    }

}
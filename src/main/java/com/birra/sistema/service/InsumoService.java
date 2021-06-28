package com.birra.sistema.service;

import com.birra.sistema.entity.Insumo;
import com.birra.sistema.exception.UserNotFoundException;
import com.birra.sistema.repository.InsumoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InsumoService {

    private final InsumoRepo insumoRepo;

    @Autowired
    public InsumoService(InsumoRepo insumoRepo) {
        this.insumoRepo = insumoRepo;
    }

    public Insumo addInsumo(Insumo insumo) {
        return insumoRepo.save(insumo);
    }

    public List<Insumo> findAllInsumos() {
        return insumoRepo.findAll();
    }

    public Insumo updateInsumo(Insumo insumo) {
        return insumoRepo.save(insumo);
    }

    public Insumo findInsumoById(Long id) {
        return insumoRepo.findInsumoById(id)
                .orElseThrow(() -> new UserNotFoundException("El Insumo nro" + id + " no existe"));
    }

    public Insumo findInsumoByNombre(String name) {
        return insumoRepo.findInsumoByNombre(name)
                .orElseThrow(() -> new UserNotFoundException("El Insumo " + name + " no existe"));
    }

    public void deleteInsumo(Long id) {
        insumoRepo.deleteInsumoById(id);
    }
}

package com.birra.sistema.service;


import com.birra.sistema.entity.UnidadDeMedida;
import com.birra.sistema.entity.Fabrica;
import com.birra.sistema.exception.UserNotFoundException;
import com.birra.sistema.repository.UnidadDeMedidaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UnidadDeMedidaService {

    private final UnidadDeMedidaRepo unidadDeMedidaRepo;

    @Autowired
    public UnidadDeMedidaService(UnidadDeMedidaRepo unidadDeMedidaRepo) {
        this.unidadDeMedidaRepo = unidadDeMedidaRepo;
    }

    public UnidadDeMedida addUnidadDeMedida(UnidadDeMedida unidadDeMedida) {
        return unidadDeMedidaRepo.save(unidadDeMedida);
    }

    public List<UnidadDeMedida> findAllUnidadDeMedidas() {
        return unidadDeMedidaRepo.findAll();
    }

    public UnidadDeMedida updateUnidadDeMedida(UnidadDeMedida unidadDeMedida) {
        return unidadDeMedidaRepo.save(unidadDeMedida);
    }

    public UnidadDeMedida findUnidadDeMedidaById(Long id) {
        return unidadDeMedidaRepo.findUnidadDeMedidaById(id)
                .orElseThrow(() -> new UserNotFoundException("UnidadDeMedida nro" + id + " no existe"));
    }

    public UnidadDeMedida findUnidadDeMedidaByNombre(String name) {
        return unidadDeMedidaRepo.findUnidadDeMedidaByNombre(name)
                .orElseThrow(() -> new UserNotFoundException("La UnidadDeMedida " + name + " no existe"));
    }

    public void deleteUnidadDeMedida(Long id) {
        unidadDeMedidaRepo.deleteUnidadDeMedidaById(id);
    }

}

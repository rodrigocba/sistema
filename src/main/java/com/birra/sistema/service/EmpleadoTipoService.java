package com.birra.sistema.service;

import com.birra.sistema.entity.EmpleadoTipo;
import com.birra.sistema.exception.UserNotFoundException;
import com.birra.sistema.repository.EmpleadoTipoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmpleadoTipoService {

    private final EmpleadoTipoRepo empleadoTipoRepo;

    @Autowired
    public EmpleadoTipoService(EmpleadoTipoRepo empleadoTipoRepo) {
        this.empleadoTipoRepo = empleadoTipoRepo;
    }

    public EmpleadoTipo addEmpleadoTipo(EmpleadoTipo empleadoTipo) {
        return empleadoTipoRepo.save(empleadoTipo);
    }

    public List<EmpleadoTipo> findAllEmpleadoTipos() {
        return empleadoTipoRepo.findAll();
    }

    public EmpleadoTipo updateEmpleadoTipo(EmpleadoTipo empleadoTipo) {
        return empleadoTipoRepo.save(empleadoTipo);
    }

    public EmpleadoTipo findEmpleadoTipoById(Long id) {
        return empleadoTipoRepo.findEmpleadoTipoById(id)
                .orElseThrow(() -> new UserNotFoundException("EmpleadoTipo nro" + id + " no existe"));
    }

    public EmpleadoTipo findEmpleadoTipoByNombre(String name) {
        return empleadoTipoRepo.findEmpleadoTipoByNombre(name)
                .orElseThrow(() -> new UserNotFoundException("La EmpleadoTipo " + name + " no existe"));
    }

    public void deleteEmpleadoTipo(Long id) {
        empleadoTipoRepo.deleteEmpleadoTipoById(id);
    }

}
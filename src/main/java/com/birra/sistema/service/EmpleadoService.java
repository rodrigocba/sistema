package com.birra.sistema.service;


import com.birra.sistema.entity.Empleado;
import com.birra.sistema.entity.Fabrica;
import com.birra.sistema.exception.UserNotFoundException;
import com.birra.sistema.repository.EmpleadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmpleadoService {

    private final EmpleadoRepo empleadoRepo;

    @Autowired
    public EmpleadoService(EmpleadoRepo empleadoRepo) {
        this.empleadoRepo = empleadoRepo;
    }

    public Empleado addEmpleado(Empleado empleado) {
        return empleadoRepo.save(empleado);
    }

    public List<Empleado> findAllEmpleados() {
        return empleadoRepo.findAll();
    }

    public Empleado updateEmpleado(Empleado empleado) {
        return empleadoRepo.save(empleado);
    }

    public Empleado findEmpleadoById(Long id) {
        return empleadoRepo.findEmpleadoById(id)
                .orElseThrow(() -> new UserNotFoundException("Empleado nro" + id + " no existe"));
    }

    public Empleado findEmpleadoByNombre(String name) {
        return empleadoRepo.findEmpleadoByNombre(name)
                .orElseThrow(() -> new UserNotFoundException("La Empleado " + name + " no existe"));
    }

    public void deleteEmpleado(Long id) {
        empleadoRepo.deleteEmpleadoById(id);
    }

    public Empleado findEmpleadoByFabrica(Fabrica fabrica) {
        return empleadoRepo.findEmpleadoByFabrica(fabrica).orElseThrow(() -> new UserNotFoundException("El Empleado buscado no existe"));
    }
}
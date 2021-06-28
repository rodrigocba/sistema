package com.birra.sistema.service;


import com.birra.sistema.entity.Proveedor;

import com.birra.sistema.exception.UserNotFoundException;
import com.birra.sistema.repository.ProveedorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProveedorService {

    private final ProveedorRepo proveedorRepo;

    @Autowired
    public ProveedorService(ProveedorRepo proveedorRepo) {
        this.proveedorRepo = proveedorRepo;
    }

    public Proveedor addProveedor(Proveedor proveedor) {
        return proveedorRepo.save(proveedor);
    }

    public List<Proveedor> findAllProveedors() {
        return proveedorRepo.findAll();
    }

    public Proveedor updateProveedor(Proveedor proveedor) {
        return proveedorRepo.save(proveedor);
    }

    public Proveedor findProveedorById(Long id) {
        return proveedorRepo.findProveedorById(id)
                .orElseThrow(() -> new UserNotFoundException("Proveedor nro" + id + " no existe"));
    }

    public Proveedor findProveedorByNombre(String name) {
        return proveedorRepo.findProveedorByNombre(name)
                .orElseThrow(() -> new UserNotFoundException("La Proveedor " + name + " no existe"));
    }

    public void deleteProveedor(Long id) {
        proveedorRepo.deleteProveedorById(id);
    }


}
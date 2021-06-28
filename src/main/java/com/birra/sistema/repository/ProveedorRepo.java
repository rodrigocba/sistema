package com.birra.sistema.repository;

import com.birra.sistema.entity.Proveedor;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface ProveedorRepo extends JpaRepository<Proveedor, Long> {

    void deleteProveedorById(Long id);

    Optional<Proveedor> findProveedorById(Long id);
    Optional<Proveedor> findProveedorByNombre(String nombre);



}

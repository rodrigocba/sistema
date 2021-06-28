package com.birra.sistema.repository;

import com.birra.sistema.entity.EmpleadoTipo;
import com.birra.sistema.entity.Fabrica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpleadoTipoRepo extends JpaRepository<EmpleadoTipo, Long> {
    void deleteEmpleadoTipoById(Long id);

    Optional<EmpleadoTipo> findEmpleadoTipoById(Long id);
    Optional<EmpleadoTipo> findEmpleadoTipoByNombre(String nombre);
}

package com.birra.sistema.repository;

import com.birra.sistema.entity.Fabrica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FabricaRepo extends JpaRepository<Fabrica, Long> {

    void deleteFabricaById(Long id);

    Optional<Fabrica> findFabricaById(Long id);
    Optional<Fabrica> findFabricaByNombre(String nombre);
}

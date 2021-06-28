package com.birra.sistema.repository;

import com.birra.sistema.entity.Insumo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InsumoRepo extends JpaRepository<Insumo, Long> {

    void deleteInsumoById(Long id);

    Optional<Insumo> findInsumoById(Long id);
    Optional<Insumo> findInsumoByNombre(String nombre);

}
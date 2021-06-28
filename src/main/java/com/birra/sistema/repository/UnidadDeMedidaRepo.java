package com.birra.sistema.repository;

import com.birra.sistema.entity.UnidadDeMedida;
import com.birra.sistema.entity.Fabrica;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UnidadDeMedidaRepo extends JpaRepository<UnidadDeMedida, Long> {

    void deleteUnidadDeMedidaById(Long id);

    Optional<UnidadDeMedida> findUnidadDeMedidaById(Long id);
    Optional<UnidadDeMedida> findUnidadDeMedidaByNombre(String nombre);





}

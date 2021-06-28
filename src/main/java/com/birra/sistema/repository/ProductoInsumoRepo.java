package com.birra.sistema.repository;

import com.birra.sistema.entity.ProductoInsumo;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface ProductoInsumoRepo extends JpaRepository<ProductoInsumo, Long> {

    void deleteProductoInsumoById(Long id);

    Optional<ProductoInsumo> findProductoInsumoById(Long id);
    Optional<ProductoInsumo> findProductoInsumoByNombre(String nombre);






}

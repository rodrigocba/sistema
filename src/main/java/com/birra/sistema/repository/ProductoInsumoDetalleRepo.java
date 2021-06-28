package com.birra.sistema.repository;

import com.birra.sistema.entity.ProductoInsumoDetalle;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface ProductoInsumoDetalleRepo extends JpaRepository<ProductoInsumoDetalle, Long> {

    void deleteProductoInsumoDetalleById(Long id);

    Optional<ProductoInsumoDetalle> findProductoInsumoDetalleById(Long id);



}

package com.birra.sistema.repository;
import com.birra.sistema.entity.OrdenDeCompra;
import com.birra.sistema.entity.ProductoInsumo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface OrdenDeCompraRepo extends JpaRepository<OrdenDeCompra, Long> {

    void deleteOrdenDeCompraById(Long id);

    Optional<OrdenDeCompra> findOrdenDeCompraById(Long id);






}
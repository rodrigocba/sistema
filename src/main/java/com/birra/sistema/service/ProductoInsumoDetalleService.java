package com.birra.sistema.service;


import com.birra.sistema.entity.ProductoInsumoDetalle;

import com.birra.sistema.exception.UserNotFoundException;
import com.birra.sistema.repository.ProductoInsumoDetalleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductoInsumoDetalleService {

    private final ProductoInsumoDetalleRepo productoInsumoDetalleRepo;

    @Autowired
    public ProductoInsumoDetalleService(ProductoInsumoDetalleRepo productoInsumoDetalleRepo) {
        this.productoInsumoDetalleRepo = productoInsumoDetalleRepo;
    }

    public ProductoInsumoDetalle addProductoInsumoDetalle(ProductoInsumoDetalle productoInsumoDetalle) {
        return productoInsumoDetalleRepo.save(productoInsumoDetalle);
    }

    public List<ProductoInsumoDetalle> findAllProductoInsumoDetalles() {
        return productoInsumoDetalleRepo.findAll();
    }

    public ProductoInsumoDetalle updateProductoInsumoDetalle(ProductoInsumoDetalle productoInsumoDetalle) {
        return productoInsumoDetalleRepo.save(productoInsumoDetalle);
    }

    public ProductoInsumoDetalle findProductoInsumoDetalleById(Long id) {
        return productoInsumoDetalleRepo.findProductoInsumoDetalleById(id)
                .orElseThrow(() -> new UserNotFoundException("ProductoInsumoDetalle nro" + id + " no existe"));
    }


    public void deleteProductoInsumoDetalle(Long id) {
        productoInsumoDetalleRepo.deleteProductoInsumoDetalleById(id);
    }


}
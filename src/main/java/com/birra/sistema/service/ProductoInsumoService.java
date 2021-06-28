package com.birra.sistema.service;


import com.birra.sistema.entity.ProductoInsumo;
import com.birra.sistema.entity.Fabrica;
import com.birra.sistema.exception.UserNotFoundException;
import com.birra.sistema.repository.ProductoInsumoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductoInsumoService {

    private final ProductoInsumoRepo productoInsumoRepo;

    @Autowired
    public ProductoInsumoService(ProductoInsumoRepo productoInsumoRepo) {
        this.productoInsumoRepo = productoInsumoRepo;
    }

    public ProductoInsumo addProductoInsumo(ProductoInsumo productoInsumo) {
        return productoInsumoRepo.save(productoInsumo);
    }

    public List<ProductoInsumo> findAllProductoInsumos() {
        return productoInsumoRepo.findAll();
    }

    public ProductoInsumo updateProductoInsumo(ProductoInsumo productoInsumo) {
        return productoInsumoRepo.save(productoInsumo);
    }

    public ProductoInsumo findProductoInsumoById(Long id) {
        return productoInsumoRepo.findProductoInsumoById(id)
                .orElseThrow(() -> new UserNotFoundException("ProductoInsumo nro" + id + " no existe"));
    }

    public ProductoInsumo findProductoInsumoByNombre(String name) {
        return productoInsumoRepo.findProductoInsumoByNombre(name)
                .orElseThrow(() -> new UserNotFoundException("La ProductoInsumo " + name + " no existe"));
    }

    public void deleteProductoInsumo(Long id) {
        productoInsumoRepo.deleteProductoInsumoById(id);
    }


}
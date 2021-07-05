package com.birra.sistema.entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class OrdenDeCompraDetalle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @OneToOne
    @JoinColumn (name = "producto_id")
    private ProductoInsumo producto;
    private double cantidad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductoInsumo getProducto() {
        return producto;
    }

    public void setProducto(ProductoInsumo producto) {
        this.producto = producto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public OrdenDeCompraDetalle() {
    }

    public OrdenDeCompraDetalle(Long id, ProductoInsumo producto, double cantidad) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
    }
}

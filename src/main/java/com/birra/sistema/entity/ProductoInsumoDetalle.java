package com.birra.sistema.entity;


import javax.persistence.*;

@Entity
public class ProductoInsumoDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn (name = "insumo_id")
    private Insumo insumo;

    private Double cantidad;

    @ManyToOne
    @JoinColumn(name ="productoInsumo_id", nullable = false)
    private ProductoInsumo productoInsumo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoInsumo getProductoInsumo() {
        return productoInsumo;
    }

    public void setProductoInsumo(ProductoInsumo productoInsumo) {
        this.productoInsumo = productoInsumo;
    }

    public ProductoInsumoDetalle(Long id, Insumo insumo, Double cantidad, ProductoInsumo productoInsumo) {
        this.id = id;
        this.insumo = insumo;
        this.cantidad = cantidad;
        this.productoInsumo = productoInsumo;
    }

    public ProductoInsumoDetalle() {
    }
}

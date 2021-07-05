package com.birra.sistema.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "producto_insumo_detalle")
public class ProductoInsumoDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @OneToOne
    @JoinColumn (name = "insumo_id")
    private Insumo insumo;

    private Double cantidad;


//    @ManyToOne
//    private ProductoInsumo productoInsumo;

//    public ProductoInsumoDetalle(ProductoInsumo productoInsumo) {
//        this.productoInsumo = productoInsumo;
//    }

    public ProductoInsumoDetalle() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoInsumoDetalle that = (ProductoInsumoDetalle) o;
        return Objects.equals(id, that.id) && Objects.equals(insumo, that.insumo) && Objects.equals(cantidad, that.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, insumo, cantidad);
    }

    public ProductoInsumoDetalle(Long id, Insumo insumo, Double cantidad) {
        this.id = id;
        this.insumo = insumo;
        this.cantidad = cantidad;
//        this.productoInsumo = productoInsumo;
    }

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
}

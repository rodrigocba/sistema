package com.birra.sistema.entity;

import javax.persistence.*;

@Entity
public class RecetaDetalleInsumo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn (name = "insumo_id")
    private Insumo insumo;
    private Double cantidad;
    private String detalle;

    @ManyToOne
    @JoinColumn(name="receta_id")
    private Receta receta;

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

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public RecetaDetalleInsumo(Long id, Insumo insumo, Double cantidad, String detalle, Receta receta) {
        this.id = id;
        this.insumo = insumo;
        this.cantidad = cantidad;
        this.detalle = detalle;
        this.receta = receta;
    }

    public RecetaDetalleInsumo() {
    }
}

package com.birra.sistema.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class OrdenDeCompra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Date Fecha;
    private Date fechaEntrega;
    @OneToOne
    @JoinColumn (name = "proveedor_id")
    private Proveedor proveedor;

    @OneToOne
    @JoinColumn (name = "fabrica_id")
    private Fabrica fabrica;


    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn (name="orden_de_compra_id")
    private List<OrdenDeCompraDetalle> ordenDetalle;
    private Double montoTotalEstimado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Fabrica getFabrica() {
        return fabrica;
    }

    public void setFabrica(Fabrica fabrica) {
        this.fabrica = fabrica;
    }

    public List<OrdenDeCompraDetalle> getOrdenDetalle() {
        return ordenDetalle;
    }

    public void setOrdenDetalle(List<OrdenDeCompraDetalle> ordenDetalle) {
        this.ordenDetalle = ordenDetalle;
    }

    public Double getMontoTotalEstimado() {
        return montoTotalEstimado;
    }

    public void setMontoTotalEstimado(Double montoTotalEstimado) {
        this.montoTotalEstimado = montoTotalEstimado;
    }

    public OrdenDeCompra() {
    }

    public OrdenDeCompra(Long id, Date fecha, Date fechaEntrega, Proveedor proveedor, Fabrica fabrica, List<OrdenDeCompraDetalle> ordenDetalle, Double montoTotalEstimado) {
        this.id = id;
        Fecha = fecha;
        this.fechaEntrega = fechaEntrega;
        this.proveedor = proveedor;
        this.fabrica = fabrica;
        this.ordenDetalle = ordenDetalle;
        this.montoTotalEstimado = montoTotalEstimado;
    }
}
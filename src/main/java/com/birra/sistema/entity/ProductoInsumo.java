package com.birra.sistema.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

//Este producto representa a lo que vende un proveedor bolsa de malta = 25kg de malta, etc
@Entity
public class ProductoInsumo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @OneToMany (mappedBy = "productoInsumo", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<ProductoInsumoDetalle> detalleProducto;

    private String nombre;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn (name = "proveedor_id")
    private Proveedor proveedor;

    private Double precioActual;
    private Date fechaActualizacion;

    public ProductoInsumo(List<ProductoInsumoDetalle> detalleProducto, String nombre, Proveedor proveedor, Double precioActual, Date fechaActualizacion) {
        this.detalleProducto = detalleProducto;
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.precioActual = precioActual;
        this.fechaActualizacion = fechaActualizacion;
    }

    public ProductoInsumo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductoInsumoDetalle> getDetalleProducto() {
        return detalleProducto;
    }

    public void setDetalleProducto(List<ProductoInsumoDetalle> detalleProducto) {
        this.detalleProducto = detalleProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Double getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(Double precioActual) {
        this.precioActual = precioActual;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}

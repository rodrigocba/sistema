package com.birra.sistema.entity;

import org.hibernate.loader.collection.OneToManyJoinWalker;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

//Este producto representa a lo que vende un proveedor bolsa de malta = 25kg de malta, etc

@Entity
@Table(name = "producto_insumo")
public class ProductoInsumo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;


    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn (name="producto_insumo_id")
    private List<ProductoInsumoDetalle> productoInsumoDetalle;

    private String nombre;

    @OneToOne
    @JoinColumn (name = "proveedor_id")
    private Proveedor proveedor;

    private Double precioActual;
    private Date fechaActualizacion;
    private String descripcion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoInsumo that = (ProductoInsumo) o;
        return Objects.equals(id, that.id) && Objects.equals(productoInsumoDetalle, that.productoInsumoDetalle) && Objects.equals(nombre, that.nombre) && Objects.equals(proveedor, that.proveedor) && Objects.equals(precioActual, that.precioActual) && Objects.equals(fechaActualizacion, that.fechaActualizacion) && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productoInsumoDetalle, nombre, proveedor, precioActual, fechaActualizacion, descripcion);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductoInsumoDetalle> getProductoInsumoDetalle() {
        return productoInsumoDetalle;
    }

    public void setProductoInsumoDetalle(List<ProductoInsumoDetalle> productoInsumoDetalle) {
        this.productoInsumoDetalle = productoInsumoDetalle;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ProductoInsumo(Long id, List<ProductoInsumoDetalle> productoInsumoDetalle, String nombre, Proveedor proveedor, Double precioActual, Date fechaActualizacion, String descripcion) {
        this.id = id;
        this.productoInsumoDetalle = productoInsumoDetalle;
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.precioActual = precioActual;
        this.fechaActualizacion = fechaActualizacion;
        this.descripcion = descripcion;
    }

    public ProductoInsumo() {
    }
}

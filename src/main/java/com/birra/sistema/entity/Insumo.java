package com.birra.sistema.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Insumo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nombre;

    @OneToOne
    @JoinColumn (name = "unidad_medida_id")
    private UnidadDeMedida unidadDeMedida;


    public Insumo(Long id, String nombre, UnidadDeMedida unidadDeMedida) {
        this.id = id;
        this.nombre = nombre;
        this.unidadDeMedida = unidadDeMedida;

    }

    public Insumo() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UnidadDeMedida getUnidadDeMedida() {
        return unidadDeMedida;
    }

    public void setUnidadDeMedida(UnidadDeMedida unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insumo insumo = (Insumo) o;
        return Objects.equals(nombre, insumo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}

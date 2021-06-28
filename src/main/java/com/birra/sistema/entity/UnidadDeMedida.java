package com.birra.sistema.entity;
import javax.persistence.*;
import java.io.Serializable;
@Entity
public class UnidadDeMedida implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nombre;

    public UnidadDeMedida(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public UnidadDeMedida() {
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
}

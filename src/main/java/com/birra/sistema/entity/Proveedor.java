package com.birra.sistema.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Proveedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nombre;
    private String telefono;
    private String web;
    private String direccion;
    private String cuit;

    public Proveedor(Long id, String nombre, String telefono, String web, String direccion, String cuit) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.web = web;
        this.direccion = direccion;
        this.cuit = cuit;
    }

    public Proveedor(String nombre) {
        this.nombre = nombre;
    }

    public Proveedor() {

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
}

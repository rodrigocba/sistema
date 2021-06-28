package com.birra.sistema.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Fabrica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nombre;
    private String razonSocial;
    private String cuit;
    private String direccion;
    private String telefono;
    private String mail;
    private String logoUrl;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }



    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }



    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    private String web;

    public Fabrica(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Fabrica() {

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

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Fabrica{" +
                "nombre='" + nombre + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                ", cuit='" + cuit + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fabrica fabrica = (Fabrica) o;
        return Objects.equals(id, fabrica.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Fabrica(Long id, String nombre, String razonSocial, String cuit, String direccion, String telefono, String web, String logoUrl,String mail) {
        this.id = id;
        this.nombre = nombre;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.direccion = direccion;
        this.telefono = telefono;
        this.web  = web;
        this.logoUrl = logoUrl;
        this.mail = mail;
    }
}

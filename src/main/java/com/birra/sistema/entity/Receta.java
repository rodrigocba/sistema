package com.birra.sistema.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Receta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nombre;
    private Long litros;
    private Double di;
    private Double df;
    private Double abv;
    private Double ibu;
    private Double srm;

    @OneToMany (mappedBy = "receta", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<RecetaDetalleInsumo> detalle;

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

    public Long getLitros() {
        return litros;
    }

    public void setLitros(Long litros) {
        this.litros = litros;
    }

    public Double getDi() {
        return di;
    }

    public void setDi(Double di) {
        this.di = di;
    }

    public Double getDf() {
        return df;
    }

    public void setDf(Double df) {
        this.df = df;
    }

    public Double getAbv() {
        return abv;
    }

    public void setAbv(Double abv) {
        this.abv = abv;
    }

    public Double getIbu() {
        return ibu;
    }

    public void setIbu(Double ibu) {
        this.ibu = ibu;
    }

    public Double getSrm() {
        return srm;
    }

    public void setSrm(Double srm) {
        this.srm = srm;
    }

    public List<RecetaDetalleInsumo> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<RecetaDetalleInsumo> detalle) {
        this.detalle = detalle;
    }

    public Receta(Long id, String nombre, Long litros, Double di, Double df, Double abv, Double ibu, Double srm, List<RecetaDetalleInsumo> detalle) {
        this.id = id;
        this.nombre = nombre;
        this.litros = litros;
        this.di = di;
        this.df = df;
        this.abv = abv;
        this.ibu = ibu;
        this.srm = srm;
        this.detalle = detalle;
    }

    public Receta() {
    }
}

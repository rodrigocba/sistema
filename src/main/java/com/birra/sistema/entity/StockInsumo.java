package com.birra.sistema.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class StockInsumo implements Serializable {

@EmbeddedId
    private StockInsumoKey id;
    @ManyToOne
    @MapsId("insumoId")
    @JoinColumn(name = "insumo_id")
    private Insumo insumo;

    @ManyToOne
    @MapsId("fabricaId")
    @JoinColumn(name = "fabrica_id")
    Fabrica fabrica;


    private Long stock;

    public StockInsumo(StockInsumoKey id, Insumo insumo, Fabrica fabrica) {
        this.id = id;
        this.insumo = insumo;
        this.fabrica = fabrica;
    }

    public StockInsumoKey getId() {
        return id;
    }

    public void setId(StockInsumoKey id) {
        this.id = id;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public Fabrica getFabrica() {
        return fabrica;
    }

    public void setFabrica(Fabrica fabrica) {
        this.fabrica = fabrica;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }
}

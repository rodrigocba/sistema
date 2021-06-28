package com.birra.sistema.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StockInsumoKey implements Serializable {

    @Column(name = "insumo_id")
    private Long insumoId;
    @Column(name = "fabrica_id")
    private Long fabricaId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockInsumoKey that = (StockInsumoKey) o;
        return Objects.equals(insumoId, that.insumoId) && Objects.equals(fabricaId, that.fabricaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(insumoId, fabricaId);
    }

    public StockInsumoKey() {

    }
}

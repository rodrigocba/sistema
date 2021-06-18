package com.birra.sistema.entity;

import java.io.Serializable;
import java.util.Objects;

public class BarrilId implements Serializable {
    private Long nroBArril;
    private Long idFabrica;

    public BarrilId(Long nroBArril, Long idFabrica) {
        this.nroBArril = nroBArril;
        this.idFabrica = idFabrica;
    }

    public BarrilId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BarrilId barrilId = (BarrilId) o;
        return Objects.equals(nroBArril, barrilId.nroBArril) && Objects.equals(idFabrica, barrilId.idFabrica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nroBArril, idFabrica);
    }
}

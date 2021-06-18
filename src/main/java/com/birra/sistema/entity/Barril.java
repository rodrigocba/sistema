package com.birra.sistema.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(BarrilId.class)
public class Barril implements Serializable{

    @Id
    private Long nroBArril;

    @Id
    private Long idFabrica;

    private Long capacidad;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn (name = "tipo_id")
    private BarrilTipo tipo;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn (name = "estado_id")
    private BarrilEstado estado;


    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn (name = "cliente_id")
    private Cliente ubicacion;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn (name = "lote_id")
    private Lote lote;
//
}

package com.birra.sistema.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Gasto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nombre;
    private Double monto;
    private Date fecha;
    private String descripcion;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn (name = "id")
    private GastoTipo tipo;


}

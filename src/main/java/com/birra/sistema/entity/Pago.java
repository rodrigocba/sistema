package com.birra.sistema.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Pago implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Double monto;
    private Date fecha;

    @ManyToOne (cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn (name="cliente_id")
    private Cliente cliente;
}

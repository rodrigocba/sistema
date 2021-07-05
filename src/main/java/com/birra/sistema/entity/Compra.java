package com.birra.sistema.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Compra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Date fecha;
     @OneToMany ( cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<ProductoInsumo> ProductoInsumos;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "proveedor_id")
    private Proveedor proveedor;
    private Double montoTotal;
}

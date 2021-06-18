package com.birra.sistema.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity

public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nombre;
    private String telefono;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "id")
    private ClienteTipo tipo;
    @OneToMany (mappedBy = "cliente", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List <Pago> pagos;
//    @OneToMany (mappedBy = "cliente", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
//    private List <Pedido> pedidos;
}

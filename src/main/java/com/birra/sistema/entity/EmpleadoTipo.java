package com.birra.sistema.entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class EmpleadoTipo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nombre;
}

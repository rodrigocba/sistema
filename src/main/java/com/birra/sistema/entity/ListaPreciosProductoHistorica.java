package com.birra.sistema.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class ListaPreciosProductoHistorica implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(nullable = false, updatable = false)
   private Long id;

   private Double precio;
private Date fechaAlta;

   @ManyToOne
   @JoinColumn(name ="productoInsumo_id", nullable = false)
   private ProductoInsumo productoInsumo;
}

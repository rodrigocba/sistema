package com.birra.sistema.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nombre;
    private String dni;
    private String telefono;
    private String mail;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn (name = "tipo_id")
    private EmpleadoTipo tipo;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn (name = "fabrica_id")
    private Fabrica fabrica;


    public Empleado() {
    }

    public Empleado(Long id, String nombre, String dni, String telefono, String mail, EmpleadoTipo tipo, Fabrica fabrica) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.mail = mail;
        this.tipo = tipo;
        this.fabrica = fabrica;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public EmpleadoTipo getTipo() {
        return tipo;
    }

    public void setTipo(EmpleadoTipo tipo) {
        this.tipo = tipo;
    }

    public Fabrica getFabrica() {
        return fabrica;
    }

    public void setFabrica(Fabrica fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(id, empleado.id) && Objects.equals(nombre, empleado.nombre) && Objects.equals(dni, empleado.dni) && Objects.equals(telefono, empleado.telefono) && Objects.equals(mail, empleado.mail) && Objects.equals(tipo, empleado.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, dni, telefono, mail, tipo);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                ", mail='" + mail + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}

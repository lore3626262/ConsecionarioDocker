package com.uptc.frw.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @Column(name = "CEDULA")
    private Integer id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDOS")
    private String apellidos;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "TELEFONO")
    private String telefono;

    @OneToMany(mappedBy = "clienteFactura")
    @JsonIgnore
    private List<Compra> billsCliente;

    @OneToMany(mappedBy = "vendedorFactura")
    @JsonIgnore
    private List<Compra> billsvendedor;


    public Persona() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


}
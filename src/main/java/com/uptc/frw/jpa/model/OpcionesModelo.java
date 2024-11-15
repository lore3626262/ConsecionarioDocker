package com.uptc.frw.jpa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "opciones_modelo")
public class OpcionesModelo {
    @Id
    @Column(name = "ID_OPCIONES_MODELO")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;


    @OneToMany(mappedBy ="detalls" )
    private List<DetalleCompra> detalls;




    public int getId() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
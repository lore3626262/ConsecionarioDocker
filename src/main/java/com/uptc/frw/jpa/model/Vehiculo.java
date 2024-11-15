package com.uptc.frw.jpa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {
    @Id
    @Column(name = "PLACA")
    private String placa;


    @Column(name = "ID_REFERENCIA",insertable = false, updatable = false)
    private int idReferencia;

    @Column(name = "PRECIO")
    private double precio;

    @Column(name = "ESTADO")
    private char estado;

    @OneToMany(mappedBy = "vehiculoFactura")
    private List<Compra> vehiculoCompra;

    @OneToMany(mappedBy = "cesionVehiculo")
    private List<Cesion> cesion;

    @ManyToOne
    @JoinColumn(name = "ID_REFERENCIA")
    private Referencia referencia;




    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getIdReferencia() {
        return idReferencia;
    }

    public void setIdReferencia(int idReferencia) {
        this.idReferencia = idReferencia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public Referencia getReferencia() {
        return referencia;
    }

    public void setReferencia(Referencia referencia) {
        this.referencia = referencia;
    }


}
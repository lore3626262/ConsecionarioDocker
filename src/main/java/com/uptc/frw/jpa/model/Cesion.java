package com.uptc.frw.jpa.model;

import jakarta.persistence.*;

import java.util.Date;




@Entity
@Table(name = "cesion")
public class Cesion {
    @Id
    @Column(name = "ID_CESION")
    private int id;

    @Column(name = "PLACA",insertable = false, updatable = false)
    private String placa;

    @Column(name = "NUMERO_FACTURA",insertable = false, updatable = false)
    private int numeroFactura;

    @Column(name = "TASACION")
    private double tasacion;

    @Column(name = "FECHA_CESION")
    private Date fechaCesion;

    @ManyToOne
    @JoinColumn(name = "PLACA")
    private Vehiculo cesionVehiculo;

    @ManyToOne
    @JoinColumn(name = "NUMERO_FACTURA")
    private Compra cesionCompra;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public double getTasacion() {
        return tasacion;
    }

    public void setTasacion(double tasacion) {
        this.tasacion = tasacion;
    }

    public Date getFechaCesion() {
        return fechaCesion;
    }

    public void setFechaCesion(Date fechaCesion) {
        this.fechaCesion = fechaCesion;
    }

    public Vehiculo getCesionVehiculo() {
        return cesionVehiculo;
    }

    public void setCesionVehiculo(Vehiculo cesionVehiculo) {
        this.cesionVehiculo = cesionVehiculo;
    }

    public Compra getCesionCompra() {
        return cesionCompra;
    }

    public void setCesionCompra(Compra cesionCompra) {
        this.cesionCompra = cesionCompra;
    }
}
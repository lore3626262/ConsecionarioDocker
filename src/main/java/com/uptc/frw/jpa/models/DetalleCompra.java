package com.uptc.frw.jpa.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="detalle_compra")

public class DetalleCompra {
    @Id
    @Column(name = "ID_DETALLE")
    private int idDetalle;

    @Column(name = "NUMERO_FACTURA",insertable = false, updatable = false)
    private int numeroFactura;

    @Column(name = "ID_OPCIONES_MODELO",insertable = false, updatable = false)
    private int idOpcionesModelo;

    @ManyToOne
    @JoinColumn(name = "NUMERO_FACTURA")
    private Compra detallecompra;

    @ManyToOne
    @JoinColumn(name = "ID_OPCIONES_MODELO")
    private OpcionesModelo opcionesmodelo;

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public int getIdOpcionesModelo() {
        return idOpcionesModelo;
    }

    public void setIdOpcionesModelo(int idOpcionesModelo) {
        this.idOpcionesModelo = idOpcionesModelo;
    }

    public Compra getDetallecompra() {
        return detallecompra;
    }

    public void setDetallecompra(Compra detallecompra) {
        this.detallecompra = detallecompra;
    }

    public OpcionesModelo getOpcionesmodelo() {
        return opcionesmodelo;
    }

    public void setOpcionesmodelo(OpcionesModelo opcionesmodelo) {
        this.opcionesmodelo = opcionesmodelo;
    }
}
package com.uptc.frw.jpa.model;

import jakarta.persistence.*;

@Entity
@Table(name="detalle_compra")

public class DetalleCompra {
    @Id
    @Column(name = "ID_DETALLE")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idDetalle;

    @Column(name = "NUMERO_FACTURA",insertable = false, updatable = false)
    private int numeroFactura;

    @Column(name = "ID_OPCIONES_MODELO",insertable = false, updatable = false)
    private int idOpcionesModelo;

    @ManyToOne
    @JoinColumn(name = "NUMERO_FACTURA")
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "ID_OPCIONES_MODELO")
    private OpcionesModelo detalls;


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



    public OpcionesModelo getDetalls() {
        return detalls;
    }

    public void setDetalls(OpcionesModelo detalls) {
        this.detalls = detalls;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
}
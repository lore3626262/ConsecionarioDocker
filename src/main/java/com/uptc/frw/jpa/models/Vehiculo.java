package com.uptc.frw.jpa.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
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
    private String estado;

    @OneToMany(mappedBy = "vendedorFactura")
    private List<Compra> vehiculoCompra;

    @ManyToOne
    @JoinColumn(name = "ID_REFERENCIA")
    private Referencia referencia;

    @OneToMany(mappedBy = "cesionVehiculo")
    private List<Cesion> cesion;
    





}
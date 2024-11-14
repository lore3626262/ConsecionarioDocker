package com.uptc.frw.jpa.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "referencia")
public class Referencia {
    @Id
    @Column(name = "ID_REFERENCIA")
    private Integer id;

    @Column(name = "MARCA")
    private String marca;

    @Column(name = "MODELO")
    private String modelo;

    @Column(name = "ANIO")
    private Integer anio;

    @OneToMany(mappedBy = "referencia")
    private List<Vehiculo> destallesVehiculos;

}
package com.uptc.frw.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "referencia")
public class Referencia {
    @Id
    @Column(name = "ID_REFERENCIA")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "MARCA")
    private String marca;

    @Column(name = "MODELO")
    private String modelo;

    @Column(name = "ANIO")
    private Integer anio;

    @OneToMany(mappedBy = "referencia")
    @JsonIgnore
    private List<Vehiculo> referencias;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public List<Vehiculo> getReferencias() {
        return referencias;
    }

    public void setReferencias(List<Vehiculo> referencias) {
        this.referencias = referencias;
    }
}
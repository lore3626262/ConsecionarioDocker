package com.uptc.frw.jpa.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "compra")
public class Compra {
    @Id
    @Column(name = "NUMERO_FACTURA")
    private int id;


    @Column(name = "CEDULA_CLIENTE",insertable = false, updatable = false)
    private int cedulaCliente;


    @Column(name = "CEDULA_VENDEDOR",insertable = false, updatable = false)
    private int cedulaVendedor;

    @Column(name = "PLACA",insertable = false, updatable = false)
    private String placa;

    @Column(name = "PRECIO_TOTAL")
    private double precioTotal;

    @Column(name = "FECHA")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "CEDULA_CLIENTE")
    private Persona clienteFactura;

    @ManyToOne
    @JoinColumn (name="CEDULA_VENDEDOR")
    private Persona vendedorFactura;

    @OneToMany(mappedBy = "detallecompra")
    private List<DetalleCompra> detailsCompra;

    @ManyToOne
    @JoinColumn(name = "PLACA")
    private Vehiculo vehiculoFactura;

    @ManyToOne
    @JoinColumn(name = "ID_REFERENCIA")
    private Referencia referencia;

    @OneToMany(mappedBy = "cesionCompra")
    private List<Cesion> cesionCompra;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(int cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public int getCedulaVendedor() {
        return cedulaVendedor;
    }

    public void setCedulaVendedor(int cedulaVendedor) {
        this.cedulaVendedor = cedulaVendedor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Persona getClienteFactura() {
        return clienteFactura;
    }

    public void setClienteFactura(Persona clienteFactura) {
        this.clienteFactura = clienteFactura;
    }

    public Persona getVendedorFactura() {
        return vendedorFactura;
    }

    public void setVendedorFactura(Persona vendedorFactura) {
        this.vendedorFactura = vendedorFactura;
    }

    public List<DetalleCompra> getDetailsCompra() {
        return detailsCompra;
    }

    public void setDetailsCompra(List<DetalleCompra> detailsCompra) {
        this.detailsCompra = detailsCompra;
    }

    public Vehiculo getVehiculoFactura() {
        return vehiculoFactura;
    }

    public void setVehiculoFactura(Vehiculo vehiculoFactura) {
        this.vehiculoFactura = vehiculoFactura;
    }

    public Referencia getReferencia() {
        return referencia;
    }

    public void setReferencia(Referencia referencia) {
        this.referencia = referencia;
    }

    public List<Cesion> getCesionCompra() {
        return cesionCompra;
    }

    public void setCesionCompra(List<Cesion> cesionCompra) {
        this.cesionCompra = cesionCompra;
    }
}
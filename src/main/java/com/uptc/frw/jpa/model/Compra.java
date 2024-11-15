package com.uptc.frw.jpa.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUMERO_FACTURA")
    private int id;

    @Column(name = "CEDULA_CLIENTE", insertable = false, updatable = false)
    private int cedulaCliente;

    @Column(name = "CEDULA_VENDEDOR", insertable = false, updatable = false)
    private int cedulaVendedor;

    @Column(name = "PLACA", insertable = false, updatable = false)
    private String placa;

    @Column(name = "PRECIO_TOTAL")
    private double precioTotal;

    @Column(name = "FECHA")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "CEDULA_CLIENTE")
    private Persona clienteFactura;

    @ManyToOne
    @JoinColumn(name = "CEDULA_VENDEDOR")
    private Persona vendedorFactura;

    @ManyToOne
    @JoinColumn(name = "PLACA")
    private Vehiculo vehiculoFactura;

    @OneToMany(mappedBy = "compra")
    private List<DetalleCompra> detailsCompra;




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

    public Vehiculo getVehiculoFactura() {
        return vehiculoFactura;
    }

    public void setVehiculoFactura(Vehiculo vehiculoFactura) {
        this.vehiculoFactura = vehiculoFactura;
    }
}
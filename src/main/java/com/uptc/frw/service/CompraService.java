package com.uptc.frw.service;

import com.uptc.frw.jpa.model.Compra;
import com.uptc.frw.jpa.model.Persona;
import com.uptc.frw.jpa.model.Vehiculo;
import com.uptc.frw.jpa.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired

    private PersonaService personaService;
        @Lazy
    @Autowired
    private VehiculoService vehiculoService;

    public List<Compra> findAll() {
        return compraRepository.findAll();
    }

    public Compra findCompra(Integer id) {
        return compraRepository.findById(id).orElse(null);
    }

    public Compra saveCompra(Compra compra) {
        Persona cliente = personaService.findPersona(compra.getCedulaCliente());
        compra.setClienteFactura(cliente);

        Persona vendedor = personaService.findPersona(compra.getCedulaVendedor());
        compra.setVendedorFactura(vendedor);

        Vehiculo vehiculo = vehiculoService.findVehiculo(compra.getPlaca());
        compra.setVehiculoFactura(vehiculo);

        return compraRepository.save(compra);
    }

    public void deleteCompra(Integer id) {
        compraRepository.deleteById(id);
    }

    public Compra updateCompra(Compra compra) {

        Compra compraOld = findCompra(compra.getId());

        if (compraOld == null) {
            throw new IllegalArgumentException("La compra con ID " + compra.getId() + " no fue encontrada.");
        }

        compraOld.setCedulaCliente(compra.getCedulaCliente());
        compraOld.setCedulaVendedor(compra.getCedulaVendedor());
        compraOld.setPlaca(compra.getPlaca());
        compraOld.setPrecioTotal(compra.getPrecioTotal());
        compraOld.setFecha(compra.getFecha());

        return saveCompra(compraOld);
    }
}

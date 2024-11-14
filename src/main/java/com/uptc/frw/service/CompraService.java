package com.uptc.frw.service;

import com.uptc.frw.jpa.model.Compra;
import com.uptc.frw.jpa.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public List<Compra> findAll() {
        return compraRepository.findAll();
    }

    public Compra findCompra(long id) {
        return compraRepository.findById(id).orElse(null);
    }

    public Compra saveCompra(Compra compra) {
        return compraRepository.save(compra);
    }

    public void deleteCompra(long id) {
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

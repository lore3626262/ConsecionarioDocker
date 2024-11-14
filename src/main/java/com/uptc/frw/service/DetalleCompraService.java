package com.uptc.frw.service;

import com.uptc.frw.jpa.model.DetalleCompra;
import com.uptc.frw.jpa.repository.DetalleCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetalleCompraService {

    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    public List<DetalleCompra> findAll() {
        return detalleCompraRepository.findAll();
    }

    public DetalleCompra findDetalleCompra(long id) {
        return detalleCompraRepository.findById(id).orElse(null);
    }

    public DetalleCompra saveDetalleCompra(DetalleCompra detalleCompra) {
        return detalleCompraRepository.save(detalleCompra);
    }



    public void deleteDetalleCompra(long id) {
        detalleCompraRepository.deleteById(id);
    }

    public DetalleCompra updateDetalleCompra(DetalleCompra detalleCompra) {

        DetalleCompra detalleCompraOld = findDetalleCompra(detalleCompra.getIdDetalle());

        // Verificar si detalleCompraOld es nulo para evitar errores
        if (detalleCompraOld == null) {
            throw new IllegalArgumentException("El detalle de compra con ID " + detalleCompra.getIdDetalle()+ " no fue encontrado.");
        }

        detalleCompraOld.setIdDetalle(detalleCompra.getIdDetalle());
        detalleCompraOld.setIdOpcionesModelo(detalleCompra.getIdOpcionesModelo());

        return saveDetalleCompra(detalleCompraOld);
    }

}

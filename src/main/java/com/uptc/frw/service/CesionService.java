package com.uptc.frw.service;

import com.uptc.frw.jpa.model.Cesion;
import com.uptc.frw.jpa.model.Compra;
import com.uptc.frw.jpa.model.Vehiculo;
import com.uptc.frw.jpa.repository.CesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CesionService {


    @Autowired
    private CesionRepository cesionRepository;

    @Autowired
    private VehiculoService vehiculoService;

    @Autowired
    private CompraService compraService;



    public List<Cesion> findAll() {
        return cesionRepository.findAll();
    }

    public Cesion findCesion(Integer id) {
        return cesionRepository.findById(id).orElse(null);
    }

    public Cesion saveCesion(Cesion cesion) {
        Vehiculo vehiculo = vehiculoService.findVehiculo(cesion.getPlaca());
        Compra compra= compraService.findCompra(cesion.getNumeroFactura());
        cesion.setCesionVehiculo(vehiculo);
        cesion.setCesionCompra(compra);
        return cesionRepository.save(cesion);
    }

    public void deleteCesion(Integer id) {
        cesionRepository.deleteById(id);
    }

    public Cesion updateCesion(Cesion cesion) {
        Cesion cesionOld = findCesion(cesion.getId());

        if (cesionOld == null) {
            throw new IllegalArgumentException("La cesión con ID " + cesion.getId() + " no fue encontrada.");
        }

        cesionOld.setPlaca(cesion.getPlaca());
        cesionOld.setNumeroFactura(cesion.getNumeroFactura());
        cesionOld.setTasacion(cesion.getTasacion());
        cesionOld.setFechaCesion(cesion.getFechaCesion());

        return saveCesion(cesionOld);
    }
}

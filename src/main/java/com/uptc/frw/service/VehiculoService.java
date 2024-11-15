package com.uptc.frw.service;


import com.uptc.frw.jpa.model.Vehiculo;
import com.uptc.frw.jpa.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class VehiculoService {




    @Autowired
    private VehiculoRepository vehiculoRepository;

    public List<Vehiculo> findAll() {
        return vehiculoRepository.findAll();
    }

    public Vehiculo findVehiculo(String id) {
        return vehiculoRepository.findById(id).orElse(null);
    }

    public Vehiculo saveVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    public void deleteVehiculo(String id) {
        vehiculoRepository.deleteById(id);
    }

    public Vehiculo updateVehiculo(Vehiculo vehiculo) {

        Vehiculo vehiculoOld = findVehiculo(vehiculo.getPlaca());

        if (vehiculoOld == null) {
            throw new IllegalArgumentException("El vehículo con el ID " + vehiculo.getIdReferencia() + " no se encuentra.");
        }

        vehiculoOld.setPlaca(vehiculo.getPlaca());
        vehiculoOld.setPrecio(vehiculo.getPrecio());
        vehiculoOld.setEstado(vehiculo.getEstado());


        return saveVehiculo(vehiculoOld);
    }


}

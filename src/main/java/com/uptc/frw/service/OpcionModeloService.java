package com.uptc.frw.service;

import com.uptc.frw.jpa.model.OpcionesModelo;
import com.uptc.frw.jpa.repository.OpcionesModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpcionModeloService {


    @Autowired
    private OpcionesModeloRepository opcionesModeloRepository;

    public List<OpcionesModelo> findAll() {
        return opcionesModeloRepository.findAll();
    }

    public OpcionesModelo findOpcionesModelo(long id) {
        return opcionesModeloRepository.findById(id).orElse(null);
    }

    public OpcionesModelo saveOpcionesModelo(OpcionesModelo opcionesModelo) {
        return opcionesModeloRepository.save(opcionesModelo);
    }

    public void deleteOpcionesModelo(long id) {
        opcionesModeloRepository.deleteById(id);
    }

    public OpcionesModelo updateOpcionesModelo(OpcionesModelo opcionesModelo) {

        OpcionesModelo opcionesModeloOLd = findOpcionesModelo(opcionesModelo.getId());

        if (opcionesModeloOLd != null) {
            throw new IllegalArgumentException("La persona con el numero de cedula " + opcionesModelo.getId() + " no se encuentra.");
        }

        opcionesModelo.setNombre(opcionesModelo.getNombre());
        opcionesModelo.setDescripcion(opcionesModelo.getDescripcion());
        return opcionesModeloRepository.save(opcionesModelo);
    }






}

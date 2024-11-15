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

    public OpcionesModelo findOpcionesModelo(int id) {
        return opcionesModeloRepository.findById(id).orElse(null);
    }

    public OpcionesModelo saveOpcionesModelo(OpcionesModelo opcionesModelo) {
        return opcionesModeloRepository.save(opcionesModelo);
    }

    public void deleteOpcionesModelo(int id) {
        opcionesModeloRepository.deleteById(id);
    }

    public OpcionesModelo updateOpcionesModelo(OpcionesModelo opcionesModelo) {

        if (opcionesModeloRepository.existsById(opcionesModelo.getId())) {
            opcionesModelo.setNombre(opcionesModelo.getNombre());
            opcionesModelo.setDescripcion(opcionesModelo.getDescripcion());
            return opcionesModeloRepository.save(opcionesModelo);
        }
        return null;

    }





}

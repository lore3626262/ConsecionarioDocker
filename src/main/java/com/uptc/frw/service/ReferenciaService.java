package com.uptc.frw.service;

import com.uptc.frw.jpa.model.Referencia;
import com.uptc.frw.jpa.repository.ReferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferenciaService {

    @Autowired
    private ReferenciaRepository referenciaRepository;

    public List<Referencia> findAll() {
        return referenciaRepository.findAll();
    }

    public Referencia findReferencia(int id) {
        return referenciaRepository.findById(id).orElse(null);
    }

    public Referencia saveReferencia(Referencia referencia) {
        return referenciaRepository.save(referencia);
    }

    public String deleteReferencia(int id) {

        if (referenciaRepository.findById(id).isEmpty()){
            return "La referncia con el ID"+ id +" no se encuentra";
        }
        referenciaRepository.deleteById(id);

        if (referenciaRepository.findById(id).isEmpty()) {
            return "La referencia con el ID " + id + " se ha eliminado correctamente.";
        } else {
            return "La referencia con el ID " + id + " no pudo ser eliminada";
        }

    }

    public Referencia updateReferencia(Referencia referencia) {

        Referencia referenciaOld = findReferencia(referencia.getId());

        if (referenciaOld == null) {
            throw new IllegalArgumentException("La referencia con el ID " + referencia.getId() + " no se encuentra.");
        }

        referenciaOld.setMarca(referencia.getMarca());
        referenciaOld.setModelo(referencia.getModelo());
        referenciaOld.setAnio(referencia.getAnio());


        return saveReferencia(referenciaOld);
    }

}

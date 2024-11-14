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

    public Referencia findReferencia(long id) {
        return referenciaRepository.findById(id).orElse(null);
    }

    public Referencia saveReferencia(Referencia referencia) {
        return referenciaRepository.save(referencia);
    }

    public void deleteReferencia(long id) {
        referenciaRepository.deleteById(id);
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

package com.uptc.frw.controller;

import com.uptc.frw.jpa.model.Referencia;
import com.uptc.frw.service.ReferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("referencia")
public class ReferenciaController {

    @Autowired
    private ReferenciaService referenciaService;

    @GetMapping
    public List<Referencia> getAllReferencias() {
        return referenciaService.findAll();
    }

    @GetMapping("{id}")
    public Referencia getReferencia(@PathVariable int id) {
        return referenciaService.findReferencia(id);
    }

    @PostMapping
    public Referencia saveReferencia(@RequestBody Referencia referencia) {
        return referenciaService.saveReferencia(referencia);
    }
    @DeleteMapping()
    public String deleteReferencia(@RequestParam int id) {
        return referenciaService.deleteReferencia(id);
    }

    @PutMapping
    public Referencia updateReferencia(@RequestBody Referencia referencia) {
        return referenciaService.updateReferencia(referencia);
    }
}

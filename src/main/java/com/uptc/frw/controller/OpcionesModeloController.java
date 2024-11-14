package com.uptc.frw.controller;


import com.uptc.frw.jpa.model.OpcionesModelo;
import com.uptc.frw.service.OpcionModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("opciones")
public class OpcionesModeloController {
    @Autowired
    private OpcionModeloService opcionesModeloService;

    @GetMapping
    public List<OpcionesModelo> getAllOpcionesModelo() {
        return opcionesModeloService.findAll();
    }

    @GetMapping("{id}")
    public OpcionesModelo getOpcionesModelo(@PathVariable long id) {
        return opcionesModeloService.findOpcionesModelo(id);
    }

    @PostMapping
    public OpcionesModelo saveOpcionesModelo(@RequestBody OpcionesModelo opcionesModelo) {
        return opcionesModeloService.saveOpcionesModelo(opcionesModelo);
    }

    @DeleteMapping("{id}")
    public void deleteOpcionesModelo(@PathVariable int id) {
        opcionesModeloService.deleteOpcionesModelo(id);
    }

    @PutMapping
    public OpcionesModelo updateOpcionesModelo(@RequestBody OpcionesModelo opcionesModelo) {
        return opcionesModeloService.updateOpcionesModelo(opcionesModelo);
    }
}

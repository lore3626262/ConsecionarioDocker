package com.uptc.frw.controller;

import com.uptc.frw.jpa.model.Compra;
import com.uptc.frw.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("compras")

public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping
    public List<Compra> getAllCompras() {
        return compraService.findAll();
    }

    @GetMapping("{id}")
    public Compra getCompra(@PathVariable int id) {
        return compraService.findCompra(id);
    }

    @PostMapping
    public Compra saveCompra(@RequestBody Compra compra) {
        return compraService.saveCompra(compra);
    }

    @DeleteMapping("{id}")
    public void deleteCompra(@PathVariable int id) {
        compraService.deleteCompra(id);
    }

    @PutMapping
    public Compra updateCompra(@RequestBody Compra compra) {
        return compraService.updateCompra(compra);
    }
}

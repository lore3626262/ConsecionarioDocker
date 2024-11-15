package com.uptc.frw.controller;

import com.uptc.frw.jpa.model.DetalleCompra;
import com.uptc.frw.service.DetalleCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("detalles")

public class DetalleCompraController {
    @Autowired
    private DetalleCompraService detalleCompraService;

    @GetMapping
    public List<DetalleCompra> getAllDetallesCompra() {
        return detalleCompraService.findAll();
    }

    @GetMapping("{id}")
    public DetalleCompra getDetalleCompra(@PathVariable int id) {
        return detalleCompraService.findDetalleCompra(id);
    }

    @PostMapping
    public DetalleCompra saveDetalleCompra(@RequestBody DetalleCompra detalleCompra) {
        return detalleCompraService.saveDetalleCompra(detalleCompra);
    }

    @DeleteMapping()
    public void deleteDetalleCompra(@RequestParam int id) {
        detalleCompraService.deleteDetalleCompra(id);
    }

    @PutMapping
    public DetalleCompra updateDetalleCompra(@RequestBody DetalleCompra detalleCompra) {
        return detalleCompraService.updateDetalleCompra(detalleCompra);
    }
}

package com.uptc.frw.controller;

import com.uptc.frw.jpa.model.Vehiculo;
import com.uptc.frw.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping
    public List<Vehiculo> getAllVehiculos() {

        return vehiculoService.findAll();
    }

    @GetMapping("{id}")
    public Vehiculo getVehiculo(@PathVariable String id) {
        return vehiculoService.findVehiculo(id);
    }

    @PostMapping
    public Vehiculo saveVehiculo(@RequestBody Vehiculo vehiculo) {
        return vehiculoService.saveVehiculo(vehiculo);
    }

    @DeleteMapping()
    public void deleteVehiculo(@RequestParam String id) {
        vehiculoService.deleteVehiculo(id);
    }

    @PutMapping
    public Vehiculo updateVehiculo(@RequestBody Vehiculo vehiculo) {
        return vehiculoService.updateVehiculo(vehiculo);
    }
}

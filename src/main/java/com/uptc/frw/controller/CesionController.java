package com.uptc.frw.controller;


import com.uptc.frw.jpa.model.Cesion;
import com.uptc.frw.service.CesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cesion")

public class CesionController {

    @Autowired
    private CesionService cesionService;

    @GetMapping
    public List<Cesion> getAllCesiones() {
        return cesionService.findAll();
    }

    @GetMapping("{id}")
    public Cesion getCesion(@PathVariable int id) {
        return cesionService.findCesion(id);
    }

    @PostMapping
    public Cesion saveCesion(@RequestBody Cesion cesion) {
        return cesionService.saveCesion(cesion);
    }

    @DeleteMapping("{id}")
    public void deleteCesion(@PathVariable int id) {
        cesionService.deleteCesion(id);
    }

    @PutMapping
    public Cesion updateCesion(@RequestBody Cesion cesion) {
        return cesionService.updateCesion(cesion);
    }
}

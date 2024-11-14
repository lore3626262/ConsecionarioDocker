package com.uptc.frw.controller;


import com.uptc.frw.jpa.model.Persona;
import com.uptc.frw.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persona")
public class PersonaController {
    @Autowired
    private PersonaService personaService;
    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaService.findAll();
    }
    @GetMapping("{id}")
    public Persona getPersona(@PathVariable int id) {
        return personaService.findPersona(id);
    }

    @PostMapping
    public Persona savePersona(@RequestBody Persona persona) {
        return personaService.savePersona(persona);
    }

    @DeleteMapping
    public void deletePersona(@RequestBody int id ) {
        personaService.deletePersona(id);
    }
    @PutMapping
    public Persona updatePersona(@RequestBody Persona persona) {
        return personaService.updatePersona(persona);
    }
}

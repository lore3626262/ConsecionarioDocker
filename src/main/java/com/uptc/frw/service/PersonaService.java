package com.uptc.frw.service;

import com.uptc.frw.jpa.model.Persona;
import com.uptc.frw.jpa.repository.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonasRepository personasRepository;

    public List<Persona> findAll() {
        return personasRepository.findAll();
    }

    public Persona findPersona(int id) {
        return personasRepository.findById(id).orElse(null);
    }

    public Persona savePersona(Persona persona) {
        return personasRepository.save(persona);
    }

    public void deletePersona(int id) {
        personasRepository.deleteById(id);
    }

    public Persona updatePersona(Persona persona) {

        Persona personaOld = findPersona(persona.getId());

        if (personaOld == null) {
            throw new IllegalArgumentException("La persona con el numero de cedula " + persona.getId() + " no se encuentra.");
        }
        personaOld.setNombre(persona.getNombre());
        personaOld.setApellidos(persona.getApellidos());
        personaOld.setDireccion(persona.getDireccion());
        personaOld.setTelefono(persona.getTelefono());
        return savePersona(personaOld);
    }
}

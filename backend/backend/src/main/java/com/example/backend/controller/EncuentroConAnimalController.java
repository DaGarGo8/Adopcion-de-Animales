package com.example.backend.controller;

import com.example.backend.model.EncuentroConAnimal;
import com.example.backend.service.EncuentroConAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/encuentros")
public class EncuentroConAnimalController {

    @Autowired
    private EncuentroConAnimalService encuentroConAnimalService;

    // Obtener todos los encuentros
    @GetMapping
    public List<EncuentroConAnimal> getAllEncuentros() {
        return encuentroConAnimalService.getAllEncuentros();
    }

    // Obtener un encuentro por ID
    @GetMapping("/{id}")
    public EncuentroConAnimal getEncuentroById(@PathVariable int id) {
        return encuentroConAnimalService.getEncuentroById(id);
    }

    // Crear un nuevo encuentro
    @PostMapping
    public EncuentroConAnimal createEncuentro(@RequestBody EncuentroConAnimal encuentro) {
        return encuentroConAnimalService.saveEncuentro(encuentro);
    }

    // Eliminar un encuentro por ID
    @DeleteMapping("/{id}")
    public void deleteEncuentro(@PathVariable int id) {
        encuentroConAnimalService.deleteEncuentro(id);
    }
}

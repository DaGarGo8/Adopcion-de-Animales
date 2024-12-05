package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Animal;
import com.example.backend.service.AnimalService;

@RestController
@RequestMapping("/animales")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    // Obtener todos los animales
    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }
    @GetMapping("/test-db")
    public String testDbConnection() {
        return "Conexión exitosa a la base de datos!";
    }


    // Obtener un animal por ID
    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable int id) {
        return animalService.getAnimalById(id);
    }

    // Crear un nuevo animal
    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
        return animalService.saveAnimal(animal);
    }

    // Eliminar un animal por ID
    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable int id) {
        animalService.deleteAnimal(id);
    }
}

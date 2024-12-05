package com.example.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Animal;
import com.example.backend.repository.AnimalRepository;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal getAnimalById(int id) {
        Optional<Animal> animal = animalRepository.findById(id);
        return animal.orElse(null);
    }

    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public void deleteAnimal(int id) {
        animalRepository.deleteById(id);
    }
}

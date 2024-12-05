package com.example.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.EncuentroConAnimal;
import com.example.backend.repository.EncuentroConAnimalRepository;

@Service
public class EncuentroConAnimalService {

    @Autowired
    private EncuentroConAnimalRepository encuentroConAnimalRepository;

    public List<EncuentroConAnimal> getAllEncuentros() {
        return encuentroConAnimalRepository.findAll();
    }

    public EncuentroConAnimal getEncuentroById(int id) {
        Optional<EncuentroConAnimal> encuentro = encuentroConAnimalRepository.findById(id);
        return encuentro.orElse(null);
    }

    public EncuentroConAnimal saveEncuentro(EncuentroConAnimal encuentro) {
        return encuentroConAnimalRepository.save(encuentro);
    }

    public void deleteEncuentro(int id) {
        encuentroConAnimalRepository.deleteById(id);
    }
}

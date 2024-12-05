package com.example.backend.repository;

import com.example.backend.model.EncuentroConAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncuentroConAnimalRepository extends JpaRepository<EncuentroConAnimal, Integer> {
    // Aquí puedes agregar consultas personalizadas si las necesitas
}

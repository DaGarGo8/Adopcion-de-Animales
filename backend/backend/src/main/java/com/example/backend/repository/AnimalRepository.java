package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.model.Animal;


@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
}

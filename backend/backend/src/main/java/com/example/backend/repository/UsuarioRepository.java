package com.example.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método para buscar un usuario por correo
    Optional<Usuario> findByCorreo(String correo);

    // Método para buscar usuarios por rol
    List<Usuario> findByRol(String rol);
}

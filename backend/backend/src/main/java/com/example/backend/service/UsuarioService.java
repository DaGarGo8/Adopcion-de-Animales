package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.dto.LoginRequest;
import com.example.backend.model.Usuario;
import com.example.backend.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Registrar un nuevo usuario
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Autenticar usuario (login)
    public boolean autenticarUsuario(LoginRequest loginRequest) {
        // Buscar usuario por correo
        Usuario usuario = usuarioRepository.findByCorreo(loginRequest.getCorreo()).orElse(null);
        
        // Comprobar si el usuario existe y si la contraseña coincide
        return usuario != null && usuario.getPassword().equals(loginRequest.getPassword());
    }

    // Obtener todos los usuarios
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    // Eliminar usuario
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}

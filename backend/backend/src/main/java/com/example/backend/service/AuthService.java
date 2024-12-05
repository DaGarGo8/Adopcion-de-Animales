package com.example.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend.model.Usuario;
import com.example.backend.repository.UsuarioRepository;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    // Constructor para la inyección de dependencias
    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Método para autenticar usuarios
    public boolean authenticate(String correo, String password) {
        return usuarioRepository.findByCorreo(correo)
                .map(usuario -> usuario.getPassword().equals(password))
                .orElse(false);
    }

    // Crear un nuevo usuario con asignación de valor por defecto a apellidos
    public Usuario registrarUsuario(String correo, String password, String rol, String apellidos, String identificacion) {
        // Crear un nuevo usuario
        Usuario usuario = new Usuario();
        usuario.setCorreo(correo);
        usuario.setPassword(password);
        usuario.setRol(rol != null && !rol.isEmpty() ? rol : "USER"); // Valor por defecto si rol es nulo o vacío
        usuario.setApellidos(apellidos != null && !apellidos.isEmpty() ? apellidos : "No especificado"); // Valor por defecto
        usuario.setIdentificacion(identificacion != null && !identificacion.isEmpty() ? identificacion : "No especificada"); // Valor por defecto

        // Asignar un nombre por defecto si no se proporciona
        if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
            usuario.setNombre("No especificado");
        }

        // Guardar el usuario en la base de datos
        return usuarioRepository.save(usuario);
    }

    // Crear un administrador
    public Usuario crearAdministrador(String email, String password) {
        return registrarUsuario(email, password, "ADMIN", "No especificado", "No especificada");
    }

    // Obtener lista de administradores
    public List<Usuario> obtenerAdmins() {
        return usuarioRepository.findByRol("ADMIN");
    }

    // Obtener todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }
}

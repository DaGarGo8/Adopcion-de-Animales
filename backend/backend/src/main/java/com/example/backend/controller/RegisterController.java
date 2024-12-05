package com.example.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Usuario;
import com.example.backend.service.AuthService;

@RestController  // Cambiado a @RestController para respuesta en JSON
@RequestMapping("/auth")
public class RegisterController {

    private final AuthService authService;

    @Autowired
    public RegisterController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody Usuario usuario) {
        try {
            // Verificar si los campos están vacíos y asignar valores predeterminados
            if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
                usuario.setNombre("Nombre no especificado");
            }
            if (usuario.getApellidos() == null || usuario.getApellidos().isEmpty()) {
                usuario.setApellidos("No especificado");
            }
            if (usuario.getIdentificacion() == null || usuario.getIdentificacion().isEmpty()) {
                usuario.setIdentificacion("No especificada");
            }
            if (usuario.getRol() == null || usuario.getRol().isEmpty()) {
                usuario.setRol("USER");
            }

            // Registrar el usuario
            Usuario newUser = authService.registrarUsuario(usuario.getCorreo(), usuario.getPassword(), usuario.getRol(), usuario.getApellidos(), usuario.getIdentificacion());

            // Responder con un objeto JSON estructurado
            return ResponseEntity.ok(new Response("success", "Usuario registrado con éxito", newUser));

        } catch (Exception e) {
            // Manejo de errores con una respuesta estructurada en JSON
            return ResponseEntity.status(500).body(new Response("error", "Error al registrar el usuario: " + e.getMessage(), null));
        }
    }

    // Clase para la respuesta estructurada
    public static class Response {
        private String status;
        private String message;
        private Usuario user;

        public Response(String status, String message, Usuario user) {
            this.status = status;
            this.message = message;
            this.user = user;
        }

        // Getters y setters
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Usuario getUser() {
            return user;
        }

        public void setUser(Usuario user) {
            this.user = user;
        }
    }
}

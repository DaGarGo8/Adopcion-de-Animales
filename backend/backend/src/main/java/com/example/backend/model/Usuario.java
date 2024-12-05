package com.example.backend.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")  // Esto especifica que esta entidad corresponde a la tabla 'Usuario'
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Usuario")
    private Long idUsuario;
    
    @Column(name = "Nombre", nullable = true)  // Cambia "nullable = false" por "nullable = true"
    private String nombre;
    
    @Column(name = "Apellidos", nullable = false)
    private String apellidos;

    @Column(name = "Identificacion", nullable = false, unique = true)
    private String identificacion;

    @Column(name = "Direccion")
    private String direccion;

    @Column(name = "Telefono")
    private String telefono;

    @Column(name = "Rol")
    private String rol;

    @Column(name = "Contraseña")
    private String password;

    @Column(name = "Correo")  // Nombre de columna en la base de datos sigue siendo "Correo"
    private String correo;  // Nombre de propiedad sigue siendo "correo" (camelCase)

    // Getters y setters
    public String getCorreo() {
        return correo;  // Usamos "correo" en el getter
    }

    public void setCorreo(String correo) {  // Usamos "correo" en el setter
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
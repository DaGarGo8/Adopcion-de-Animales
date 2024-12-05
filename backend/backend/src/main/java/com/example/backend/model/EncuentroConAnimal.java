package com.example.backend.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Encuentro_con_Animal")
public class EncuentroConAnimal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Encuentro")
    private Integer idEncuentro;

    @ManyToOne
    @JoinColumn(name = "ID_Usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "Fecha", nullable = false)
    private String fecha;

    @Column(name = "Hora", nullable = false)
    private String hora;

    @Column(name = "Direccion", nullable = false)
    private String direccion;

    @Column(name = "Especie")
    private String especie;

    // Getters y setters
    public Integer getIdEncuentro() {
        return idEncuentro;
    }

    public void setIdEncuentro(Integer idEncuentro) {
        this.idEncuentro = idEncuentro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}

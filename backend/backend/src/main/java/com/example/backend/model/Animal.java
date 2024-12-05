package com.example.backend.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Animal")
public class Animal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto incremento para el campo ID
    @Column(name = "ID_Animal")
    private Integer idAnimal;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Edad")
    private Integer edad;

    @Column(name = "Raza")
    private String raza;

    @Column(name = "Especie")
    private String especie;

    @Column(name = "En_Adopcion", nullable = false)
    private Boolean enAdopcion = true;  // Valor predeterminado es true

    // Getters y setters
    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Boolean getEnAdopcion() {
        return enAdopcion;
    }

    public void setEnAdopcion(Boolean enAdopcion) {
        this.enAdopcion = enAdopcion;
    }
}

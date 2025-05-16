package com.David_De_La_Puente.Reto.relaciones.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "proyectos")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private Boolean activo;

    public Proyecto() {
    }

    // Constructor con todos los atributos
    public Proyecto(String nombre, String descripcion, LocalDate fechaInicio, Boolean activo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.activo = activo;
    }

    public Proyecto(String erpEscolar, String proyectoDeErpParaEscolar, LocalDate of, boolean b) {
    }

    // Getters y Setters

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Proyecto{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio + ", estado=" + activo + '}';
    }
}

package com.David_De_La_Puente.Reto.relaciones.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    private String descripcion;

    private boolean completada;

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;

    public Tarea() {}

    public Tarea(Long id, String titulo, String descripcion, boolean completada, Proyecto proyecto) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completada = completada;
        this.proyecto = proyecto;
    }

    public Tarea(String disenyarModeloDeDatos, String CrearElModeloRelacinal, boolean b, Proyecto p1) {
        this.titulo = disenyarModeloDeDatos;
        this.descripcion = CrearElModeloRelacinal;
        this.completada = b;
        this.proyecto = p1;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public String toString() {
        return "Tarea{" + "id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", completada=" + completada + ", proyecto=" + proyecto + '}';
    }
}

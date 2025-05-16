package com.David_De_La_Puente.Reto.relaciones.runner;

import com.David_De_La_Puente.Reto.relaciones.entities.Proyecto;
import com.David_De_La_Puente.Reto.relaciones.entities.Tarea;
import com.David_De_La_Puente.Reto.relaciones.repository.ProyectoRepository;
import com.David_De_La_Puente.Reto.relaciones.repository.TareaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class RetoRunner implements CommandLineRunner {

    private final ProyectoRepository proyectoRepository;
    private final TareaRepository tareaRepository;

    public RetoRunner(ProyectoRepository proyectoRepository, TareaRepository tareaRepository) {
        this.proyectoRepository = proyectoRepository;
        this.tareaRepository = tareaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Crear Proyectos
        Proyecto p1 = new Proyecto("ERP Escolar", "Proyecto de ERP para Escolar", LocalDate.of(2025,1,1), true);
        Proyecto p2 = new Proyecto("Proyecto de ERP", "Proyecto de ERP", LocalDate.of(2025,1,1), true);

        proyectoRepository.save(p1);
        proyectoRepository.save(p2);


        // Creaqr Tareas
        Tarea t1 = new Tarea("Diseñar modelo de datos", "Crear el modelo relacinal", false, p1);
        Tarea t2 = new Tarea("Implementar backend", "API REST con Spring Noot", true, p1);
        Tarea t3 = new Tarea("Diseñar interfaz", "Frontend con React", false, p1);
        Tarea t4 = new Tarea("Escribir contenido", "Relación para páginas de servicios", true, p2);
        Tarea t5 = new Tarea("Subir a hosting", "Deploy servidor", false, p2);
        tareaRepository.saveAll(List.of(t1,t2, t3, t4, t5));

        // Consultas
        System.out.println("Proyectos por nombre: ");
        proyectoRepository.findByNombre("ERP Escolar").forEach(System.out::println);
        System.out.println("Tareas: " + tareaRepository.findAll());

        System.out.println("Proyectos por fecha de inicio: ");
        proyectoRepository.findByFechaInicio(LocalDate.of(2025,1,1)).forEach(System.out::println);

        System.out.println("Proyectos activos: ");
        proyectoRepository.findProyectosActivos().forEach(System.out::println);

        System.out.println("Tareas completadas: " + tareaRepository.countByCompletadaFalse());

        System.out.println("Tareas por proyecto: ");
        tareaRepository.findTareaByProyecto(p1).forEach(System.out::println);

        System.out.println("Tareas por titulo: ");
        tareaRepository.findByTitulo("Diseñar interfaz").forEach(System.out::println);

        System.out.println("Tareas por titulo: ");
        tareaRepository.findByTitulo("Diseñar modelo de datos").forEach(System.out::println);

        System.out.println("Tareas por titulo: ");
        tareaRepository.findByTitulo("Implementar backend").forEach(System.out::println);

        System.out.println("Tareas por titulo: ");
        tareaRepository.findByTitulo("Escribir contenido").forEach(System.out::println);

        System.out.println("Tareas por titulo: ");
        tareaRepository.findByTitulo("Subir a hosting").forEach(System.out::println);

        System.out.println("Tareas por titulo: ");
        tareaRepository.findByTitulo("No existe").forEach(System.out::println);
    }
}

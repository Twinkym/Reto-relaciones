package com.David_De_La_Puente.Reto.relaciones.repository;

import com.David_De_La_Puente.Reto.relaciones.entities.Proyecto;
import com.David_De_La_Puente.Reto.relaciones.entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findByTitulo(String titulo);

    long countByCompletadaFalse();

    @Query("Select t FROM Tarea t WHERE t.proyecto = :proyecto")
    List<Tarea> findTareaByProyecto(Proyecto proyecto);

}

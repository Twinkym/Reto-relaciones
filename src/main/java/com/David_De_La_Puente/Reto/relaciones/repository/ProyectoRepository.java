package com.David_De_La_Puente.Reto.relaciones.repository;

import com.David_De_La_Puente.Reto.relaciones.entities.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    List<Proyecto> findByNombre(String nombre);
    List<Proyecto> findByFechaInicio(LocalDate fechaInicio);

    @Query("Select p FROM Proyecto p WHERE p.activo = true")
    List<Proyecto> findProyectosActivos();
}

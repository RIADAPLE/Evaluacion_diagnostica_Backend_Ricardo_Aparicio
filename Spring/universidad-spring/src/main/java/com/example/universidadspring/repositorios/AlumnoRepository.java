package com.example.universidadspring.repositorios;

import com.example.universidadspring.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioAlumnos")
public interface AlumnoRepository extends PersonaRepository {
    @Query("select a from Alumno as a join fetch a.carrera c where c.nombre = ?1")
    Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);
}

package com.example.universidadspring.repositorios;

import com.example.universidadspring.modelo.entidades.Carrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarreraRepository extends CrudRepository<Carrera, Integer> {
    Iterable<Carrera> findCarreraByNombreContains(String nombre);
    Iterable<Carrera> findCarreraByNombreContainsIgnoreCase(String nombre);
    Iterable<Carrera> findCarreraByCantidadAnios(Integer cantidadAnios);

    @Query("select c from Carrera as c join fetch c.profesores p where p.nombre = ?1 and p.apellido = ?2")
    Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido);
}

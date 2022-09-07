package com.example.universidadspring.servicios.contratos;

import com.example.universidadspring.modelo.entidades.Carrera;

import java.util.Optional;

public interface CarreraDAO extends GenericDAO<Carrera> {
    Iterable<Carrera> findCarreraByNombreContains(String nombre);
    Iterable<Carrera> findCarreraByNombreContainsIgnoreCase(String nombre);
    Iterable<Carrera> findCarreraByCantidadAnios(Integer cantidadAnios);
    Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido);
}

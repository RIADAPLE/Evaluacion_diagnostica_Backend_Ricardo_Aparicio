package com.example.universidadspring.servicios.contratos;

import com.example.universidadspring.modelo.entidades.Carrera;
import com.example.universidadspring.modelo.entidades.Persona;

public interface AlumnoDAO extends PersonaDAO {
    Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);
}

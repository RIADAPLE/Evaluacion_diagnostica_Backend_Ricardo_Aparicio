package com.example.universidadspring.servicios.contratos;

import com.example.universidadspring.modelo.entidades.Persona;

public interface ProfesorDAO extends PersonaDAO{
    Iterable<Persona> findProfesoresByCarrera(String carrera);
}

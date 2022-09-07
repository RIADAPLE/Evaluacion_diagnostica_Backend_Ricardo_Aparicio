package com.example.universidadspring.servicios.contratos;

import com.example.universidadspring.modelo.entidades.Persona;

import java.util.Optional;

public interface PersonaDAO extends GenericDAO<Persona> {
    Optional<Persona> buscaPorNombreYApellido(String nombre, String apellido);
    Optional<Persona> buscarPorDni(String dni);
    Iterable<Persona> buscarPersonaPorApellido(String apellido);
}

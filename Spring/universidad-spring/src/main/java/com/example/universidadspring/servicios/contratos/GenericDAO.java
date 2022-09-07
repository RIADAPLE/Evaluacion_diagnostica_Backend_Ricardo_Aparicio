package com.example.universidadspring.servicios.contratos;

import com.example.universidadspring.modelo.entidades.Carrera;

import java.util.Optional;

public interface GenericDAO <E>{
    Optional<E> findById(Integer id);
    E save(E entidad);
    Iterable<E> findAll();
    void deleteById(Integer id);
}

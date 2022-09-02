package com.example.universidadspring.repositorios;

import com.example.universidadspring.modelo.entidades.Carrera;
import org.springframework.data.repository.CrudRepository;

public interface CarreraRepository extends CrudRepository<Carrera, Integer> {
    //Quitar el <Carrera, Integer> sino lo pone al final
}

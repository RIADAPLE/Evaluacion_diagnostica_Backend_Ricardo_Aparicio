package com.example.universidadspring.repositorios;

import com.example.universidadspring.modelo.entidades.Pabellon;
import org.springframework.data.repository.CrudRepository;

public interface PabellonRepository extends CrudRepository<Pabellon, Integer> {
    Iterable<Pabellon> findPabellonByDireccion_Calle(String Direccion);
    Iterable<Pabellon> findPabellonByNombre(String nombre);
}

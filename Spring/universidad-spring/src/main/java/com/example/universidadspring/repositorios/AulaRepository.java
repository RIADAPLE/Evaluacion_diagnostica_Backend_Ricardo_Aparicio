package com.example.universidadspring.repositorios;

import com.example.universidadspring.modelo.entidades.Aula;
import com.example.universidadspring.modelo.entidades.Pabellon;
import com.example.universidadspring.modelo.entidades.enumeradores.Pizarron;
import org.springframework.data.repository.CrudRepository;

public interface AulaRepository extends CrudRepository<Aula, Integer> {

    Iterable<Aula> findAulaByPizarron(Pizarron pizarron);
    Iterable<Aula> findAulaByPabellon_Nombre(String pabellon);
    Iterable<Aula> findAulaByNroAula(Integer nroAula);
}

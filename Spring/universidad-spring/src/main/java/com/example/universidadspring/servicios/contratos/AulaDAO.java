package com.example.universidadspring.servicios.contratos;

import com.example.universidadspring.modelo.entidades.Aula;
import com.example.universidadspring.modelo.entidades.Pabellon;
import com.example.universidadspring.modelo.entidades.enumeradores.Pizarron;

public interface AulaDAO extends GenericDAO<Aula> {
    Iterable<Aula> findAulaByPizarron(Pizarron pizarron);
    Iterable<Aula> findAulaByPabellon_Nombre(String pabellon);
    Iterable<Aula> findAulaByNroAula(Integer nroAula);
}

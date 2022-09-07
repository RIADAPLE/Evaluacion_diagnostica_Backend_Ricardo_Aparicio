package com.example.universidadspring.servicios.implementaciones;

import com.example.universidadspring.modelo.entidades.Aula;
import com.example.universidadspring.modelo.entidades.Pabellon;
import com.example.universidadspring.modelo.entidades.enumeradores.Pizarron;
import com.example.universidadspring.repositorios.AulaRepository;
import com.example.universidadspring.repositorios.CarreraRepository;
import com.example.universidadspring.servicios.contratos.AulaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class AulaDAOimpl extends GenericDAOimpl<Aula, AulaRepository> implements AulaDAO {

    @Autowired
    public AulaDAOimpl(AulaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Aula> findAulaByPizarron(Pizarron pizarron) {
        return repository.findAulaByPizarron(pizarron);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Aula> findAulaByPabellon_Nombre(String pabellon) {
        return repository.findAulaByPabellon_Nombre(pabellon);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Aula> findAulaByNroAula(Integer nroAula) {
        return repository.findAulaByNroAula(nroAula);
    }
}

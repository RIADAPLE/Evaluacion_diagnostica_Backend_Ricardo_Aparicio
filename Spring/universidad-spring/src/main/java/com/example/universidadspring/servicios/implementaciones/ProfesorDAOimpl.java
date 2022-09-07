package com.example.universidadspring.servicios.implementaciones;

import com.example.universidadspring.modelo.entidades.Persona;
import com.example.universidadspring.repositorios.PersonaRepository;
import com.example.universidadspring.repositorios.ProfesorRepository;
import com.example.universidadspring.servicios.contratos.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProfesorDAOimpl extends PersonaDAOimpl implements ProfesorDAO {

    @Autowired
    public ProfesorDAOimpl(@Qualifier("repositorioProfesores")PersonaRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Persona> findProfesoresByCarrera(String carrera) {
        return ((ProfesorRepository)repository).findProfesoresByCarrera(carrera);
    }
}

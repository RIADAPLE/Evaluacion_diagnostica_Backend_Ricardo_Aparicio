package com.example.universidadspring.servicios.implementaciones;

import com.example.universidadspring.modelo.entidades.Persona;
import com.example.universidadspring.repositorios.PersonaRepository;
import com.example.universidadspring.servicios.contratos.PersonaDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class PersonaDAOimpl extends GenericDAOimpl<Persona, PersonaRepository> implements PersonaDAO {

    public PersonaDAOimpl(PersonaRepository repository) {
        super(repository);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscaPorNombreYApellido(String nombre, String apellido) {
        return repository.buscarPorNombreYApellido(nombre, apellido);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorDni(String dni) {
        return repository.buscarPorDni(dni);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarPersonaPorApellido(String apellido) {
        return repository.buscarPersonaPorApellido(apellido);
    }
}

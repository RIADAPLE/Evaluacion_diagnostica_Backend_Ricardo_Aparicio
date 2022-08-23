package org.example.webapp.jaxws.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceContext;
import org.example.webapp.jaxws.models.Curso;
import org.example.webapp.jaxws.repository.CursoRepository;

import java.util.List;
import java.util.Optional;

@Stateless
public class CursoServiceImpl implements CursoService{

    @Inject
    private CursoRepository repository;

    @Override
    public List<Curso> listar() {
        return repository.listar();
    }

    @Override
    public Curso guardar(Curso curso) {

        return repository.guardar(curso);
    }

    @Override
    public Optional<Curso> porId(Long id) {
        return Optional.ofNullable(repository.porId(id));
    }

    @Override
    public void eliminar(Long id) {
        repository.eliminar(id);
    }
}

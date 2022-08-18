package org.example.webapp.jaxws.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.example.webapp.jaxws.models.Curso;
import org.example.webapp.jaxws.repositories.CursoRepository;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Arrays;
import java.util.List;

@Stateless
@WebService(endpointInterface = "org.example.webapp.jaxws.services.CursoServicioWs")
public class CursoServicioWsImpl implements CursoServicioWs {
    @Inject
    private CursoRepository repository;

    @WebMethod
    @Override
    public List<Curso> listar() {
        return repository.listar();
    }

    @Override
    @WebMethod
    public Curso guardar(Curso curso) {
        return repository.guardar(curso);
    }
}

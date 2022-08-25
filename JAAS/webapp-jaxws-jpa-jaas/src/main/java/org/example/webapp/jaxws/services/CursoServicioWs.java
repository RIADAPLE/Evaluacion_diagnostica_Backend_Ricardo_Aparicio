package org.example.webapp.jaxws.services;

import org.example.webapp.jaxws.models.Curso;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface CursoServicioWs {
    List<Curso> listar();
    Curso guardar (Curso curso);
}

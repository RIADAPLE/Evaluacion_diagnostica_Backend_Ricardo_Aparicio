package org.example.webapp.jaxws.services;

import org.example.webapp.jaxws.models.Curso;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ServicioWs {
    String saludar(String persona);
    List<Curso> listar();
    Curso crear (Curso curso);
}

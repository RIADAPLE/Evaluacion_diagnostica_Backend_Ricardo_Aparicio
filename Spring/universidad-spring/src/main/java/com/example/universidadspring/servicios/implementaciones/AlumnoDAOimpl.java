package com.example.universidadspring.servicios.implementaciones;

import com.example.universidadspring.modelo.entidades.Carrera;
import com.example.universidadspring.modelo.entidades.Persona;
import com.example.universidadspring.repositorios.AlumnoRepository;
import com.example.universidadspring.repositorios.CarreraRepository;
import com.example.universidadspring.repositorios.PersonaRepository;
import com.example.universidadspring.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AlumnoDAOimpl extends PersonaDAOimpl implements AlumnoDAO {

    @Autowired
    public AlumnoDAOimpl(@Qualifier("repositorioAlumnos")PersonaRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre) {
        return ((AlumnoRepository)repository).buscarAlumnosPorNombreCarrera(nombre);
    }
}

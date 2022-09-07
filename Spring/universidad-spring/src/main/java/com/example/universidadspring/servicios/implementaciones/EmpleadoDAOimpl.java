package com.example.universidadspring.servicios.implementaciones;

import com.example.universidadspring.modelo.entidades.Persona;
import com.example.universidadspring.modelo.entidades.enumeradores.TipoEmpleado;
import com.example.universidadspring.repositorios.AlumnoRepository;
import com.example.universidadspring.repositorios.EmpleadoRepository;
import com.example.universidadspring.repositorios.PersonaRepository;
import com.example.universidadspring.servicios.contratos.EmpleadoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoDAOimpl extends PersonaDAOimpl implements EmpleadoDAO {

    @Autowired
    public EmpleadoDAOimpl(@Qualifier("repositorioEmpleados")PersonaRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado) {
        return ((EmpleadoRepository)repository).findEmpleadoByTipoEmpleado(tipoEmpleado);
    }
}

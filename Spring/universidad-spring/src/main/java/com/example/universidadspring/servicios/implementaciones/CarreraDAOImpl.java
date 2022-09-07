package com.example.universidadspring.servicios.implementaciones;

import com.example.universidadspring.modelo.entidades.Carrera;
import com.example.universidadspring.repositorios.CarreraRepository;
import com.example.universidadspring.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class CarreraDAOImpl extends GenericDAOimpl<Carrera, CarreraRepository> implements CarreraDAO {
    @Autowired
    public CarreraDAOImpl(CarreraRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarreraByNombreContains(String nombre) {
        return repository.findCarreraByNombreContains(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarreraByNombreContainsIgnoreCase(String nombre) {
        return repository.findCarreraByNombreContainsIgnoreCase(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarreraByCantidadAnios(Integer cantidadAnios) {
        return repository.findCarreraByCantidadAnios(cantidadAnios);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido){
        return repository.buscarCarrerasPorProfesorNombreYApellido(nombre, apellido);
    }
}

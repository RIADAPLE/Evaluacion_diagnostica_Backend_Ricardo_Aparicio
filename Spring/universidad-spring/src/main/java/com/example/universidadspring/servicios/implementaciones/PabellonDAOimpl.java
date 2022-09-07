package com.example.universidadspring.servicios.implementaciones;

import com.example.universidadspring.modelo.entidades.Pabellon;
import com.example.universidadspring.repositorios.PabellonRepository;
import com.example.universidadspring.servicios.contratos.PabellonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class PabellonDAOimpl extends GenericDAOimpl<Pabellon, PabellonRepository> implements PabellonDAO {

    @Autowired
    public PabellonDAOimpl(PabellonRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Pabellon> findPabellonByDireccion_Calle(String Direccion) {
        return repository.findPabellonByDireccion_Calle(Direccion);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Pabellon> findPabellonByNombre(String nombre) {
        return repository.findPabellonByNombre(nombre);
    }
}

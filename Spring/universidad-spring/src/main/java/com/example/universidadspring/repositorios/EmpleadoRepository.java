package com.example.universidadspring.repositorios;

import com.example.universidadspring.modelo.entidades.Persona;
import com.example.universidadspring.modelo.entidades.enumeradores.TipoEmpleado;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioEmpleados")
public interface EmpleadoRepository extends PersonaRepository{
    @Query("select e from Empleado as e  where e.tipoEmpleado = ?1")
    Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);
}

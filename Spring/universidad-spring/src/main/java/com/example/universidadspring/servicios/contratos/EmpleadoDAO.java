package com.example.universidadspring.servicios.contratos;

import com.example.universidadspring.modelo.entidades.Persona;
import com.example.universidadspring.modelo.entidades.enumeradores.TipoEmpleado;

public interface EmpleadoDAO extends PersonaDAO{
    Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);
}

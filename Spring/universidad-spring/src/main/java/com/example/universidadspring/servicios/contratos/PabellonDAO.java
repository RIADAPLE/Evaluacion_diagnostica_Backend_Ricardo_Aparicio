package com.example.universidadspring.servicios.contratos;

import com.example.universidadspring.modelo.entidades.Pabellon;

public interface PabellonDAO {
    Iterable<Pabellon> findPabellonByDireccion_Calle(String Direccion);
    Iterable<Pabellon> findPabellonByNombre(String nombre);
}

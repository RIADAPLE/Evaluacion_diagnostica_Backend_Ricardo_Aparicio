package org.example.webapp.ejb.service;

import org.example.webapp.ejb.models.Producto;

import java.util.List;

public interface ServiceEjbLocal {
    String saludar(String nombre);
    Producto crear(Producto producto);
    List<Producto> listar();
}

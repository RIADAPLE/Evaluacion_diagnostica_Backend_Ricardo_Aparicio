package org.example.webapp.ejb.service;

import jakarta.ejb.Stateless;
import org.example.webapp.ejb.models.Producto;

import java.util.ArrayList;
import java.util.List;

//@RequestScoped
@Stateless
public class ServiceEjb implements ServiceEjbLocal{

    private int contador;

    public String saludar(String nombre) {
        System.out.println("imprimiendo dentro del ejb con instancia: " + this);
        contador++;
        System.out.println("valor del contador en metodo saludar: " + contador + " nombre: " + nombre);
        return "Hola que tal " + nombre;
    }

    public Producto crear(Producto producto){
        System.out.println("guardando producto ... " + producto);
        Producto p = new Producto();
        p.setNombre(producto.getNombre());
        return producto;
    }

    public List<Producto> listar(){
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Peras"));
        productos.add(new Producto("Manzanas"));
        productos.add(new Producto("Naranjas"));
        return productos;
    }
}

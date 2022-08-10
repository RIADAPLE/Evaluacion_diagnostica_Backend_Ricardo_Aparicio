package org.example;

import org.example.dto.Categoria;
import org.example.dto.Producto;
import org.example.repositorio.ProductoRepositorioImpl;
import org.example.repositorio.Repositorio;

import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {
        Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
        System.out.println("========== listar ==========");
        repositorio.listar().forEach(System.out::println);

        System.out.println("========== obtener por id ==========");
        System.out.println(repositorio.porId(1L));

        System.out.println("========== insertar nuevo producto ==========");
        Producto producto = new Producto();
        producto.setNombre("Notebook omen HP");
        producto.setPrecio(2900);
        producto.setFechaRegistro(new Date());
        Categoria categoria = new Categoria();
        categoria.setId(3L);
        producto.setCategoria(categoria);
        repositorio.guardar(producto);
        System.out.println("Producto guardado con éxito");
        repositorio.listar().forEach(System.out::println);

        /*System.out.println("========== Eliminar producto ==========");
        repositorio.eliminar(5L);
        repositorio.listar().forEach(System.out::println);*/

        System.out.println("========== Actualizar producto ==========");
        Producto producto1 = new Producto();
        producto1.setId(3L);
        producto1.setNombre("Notebook omen HP pero actualizada");
        producto1.setPrecio(3000);
        producto1.setFechaRegistro(new Date());
        Categoria categoria1 = new Categoria();
        categoria1.setId(3L);
        producto1.setCategoria(categoria1);
        repositorio.guardar(producto1);
        System.out.println("Producto guardado con éxito");
        repositorio.listar().forEach(System.out::println);
    }
}

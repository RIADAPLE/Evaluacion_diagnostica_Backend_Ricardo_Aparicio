package org.example;

import org.example.dto.Categoria;
import org.example.dto.Producto;
import org.example.jdbcDAO.Conexion;
import org.example.repositorio.CategoriaRepositorioImpl;
import org.example.repositorio.ProductoRepositorioImpl;
import org.example.repositorio.Repositorio;
import org.example.servicio.ElCatalogo;
import org.example.servicio.Servicio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {
        Servicio servicio = new ElCatalogo();
        System.out.println("========== listar ==========");
        servicio.listar().forEach(System.out::println);
        Categoria categoria = new Categoria();
        categoria.setNombre("Iluminacion");

        Producto producto = new Producto();
        producto.setNombre("Lámpara led escritorio");
        producto.setPrecio(990);
        producto.setFechaRegistro(new Date());
        producto.setSku("abcdefgh12");
        servicio.guardarProductoConCategoria(producto, categoria);
        System.out.println("Producto guardado con éxito: " + producto.getId());
        servicio.listar().forEach(System.out::println);
    }
}
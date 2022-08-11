package org.example;

import org.example.dto.Categoria;
import org.example.dto.Producto;
import org.example.jdbcDAO.Conexion;
import org.example.repositorio.CategoriaRepositorioImpl;
import org.example.repositorio.ProductoRepositorioImpl;
import org.example.repositorio.Repositorio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = Conexion.getConnection()) {
            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }
            try {
                Repositorio<Categoria> repositorioCategoria = new CategoriaRepositorioImpl(conn);
                System.out.println("========== Insertar nueva categoría ==========");
                Categoria categoria = new Categoria();
                categoria.setNombre("Electrohogar");
                Categoria nuevaCategoria = repositorioCategoria.guardar(categoria);
                System.out.println("Categoria guardada con exito: " + nuevaCategoria.getId());

                Repositorio<Producto> repositorio = new ProductoRepositorioImpl(conn);
                System.out.println("========== listar ==========");
                repositorio.listar().forEach(System.out::println);

                System.out.println("========== obtener por id ==========");
                System.out.println(repositorio.porId(1L));

                System.out.println("========== insertar nuevo producto ==========");
                Producto producto = new Producto();
                producto.setNombre("Notebook omen HP");
                producto.setPrecio(2900);
                producto.setFechaRegistro(new Date());
                producto.setSku("abcdefg123");

                producto.setCategoria(nuevaCategoria);
                repositorio.guardar(producto);
                System.out.println("Producto guardado con éxito " + producto.getId());
                repositorio.listar().forEach(System.out::println);
                /*
                System.out.println("========== Eliminar producto ==========");
                repositorio.eliminar(6L);
                repositorio.listar().forEach(System.out::println);*/

                /*System.out.println("========== Actualizar producto ==========");
                Producto producto1 = new Producto();
                producto1.setId(1L);
                producto1.setNombre("Cocina");
                producto1.setPrecio(3000);
                producto1.setFechaRegistro(new Date());
                Categoria categoria1 = new Categoria();
                categoria1.setId(1L);
                producto1.setCategoria(categoria1);
                repositorio.guardar(producto1);
                System.out.println("Producto guardado con éxito");
                repositorio.listar().forEach(System.out::println);*/

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
        }
    }
}
package org.example.hibernateapp;

import jakarta.persistence.EntityManager;
import org.example.hibernateapp.dominio.ClienteDto;
import org.example.hibernateapp.entity.Cliente;
import org.example.hibernateapp.util.JpaUtil;

import java.util.Arrays;
import java.util.List;

public class HibernateQL {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        System.out.println("===== Consultar todos =====");
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class)
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("\n===== Consulta por id =====");
        Cliente cliente = em.createQuery("SELECT c FROM Cliente c WHERE c.id=:id", Cliente.class)
                .setParameter("id",1L)
                .getSingleResult();
        System.out.println(cliente);

        System.out.println("\n===== Consulta solo el nombre por el id =====");
        String nombreCliente = em.createQuery("SELECT c.nombre FROM Cliente c WHERE c.id=:id", String.class)
                .setParameter("id", 2L)
                .getSingleResult();
        System.out.println(nombreCliente);

        System.out.println("\n===== Consulta por campos personalizados =====");
        Object[] objetoCliente = em.createQuery("SELECT c.id, c.nombre, c.apellido FROM Cliente c WHERE c.id=:id", Object[].class)
                .setParameter("id", 1L)
                .getSingleResult();
        Long id = (Long) objetoCliente[0];
        String nombre = (String) objetoCliente[1];
        String apellido = (String) objetoCliente[2];
        System.out.println("id: " + id + ", nombre: " + nombre + ", apellido: " + apellido);

        System.out.println("\n========= consulta por campos personalizados lista ==========");
        List<Object[]> registros = em.createQuery("SELECT c.id, c.nombre, c.apellido FROM Cliente c", Object[].class)
                .getResultList();
        registros.forEach(reg -> {
            Long idCli = (Long) reg[0];
            String nombreCli = (String) reg[1];
            String apellidoCli = (String) reg[2];
            System.out.println("id: " + idCli + ", nombre: " + nombreCli + ", apellido: " + apellidoCli);
        });

        System.out.println("\n===== consulta que puebla y devuelve objeto entity de una clase personalizada");
        clientes = em.createQuery("SELECT new Cliente(c.nombre, c.apellido) FROM Cliente c", Cliente.class)
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("\n===== consulta que puebla y devuelve objeto otro de una clase personalizada");
        List<ClienteDto> clientesDto = em.createQuery("SELECT new org.example.hibernateapp.dominio.ClienteDto(c.nombre, c.apellido) " +
                "FROM Cliente c", ClienteDto.class).getResultList();
        clientesDto.forEach(System.out::println);

        System.out.println("\n===== consulta con nombres de clientes =====");
        List<String> nombres = em.createQuery("SELECT c.nombre FROM Cliente c", String.class)
                .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("\n==== consulta con nombres unicos de clientes =====");
        nombres = em.createQuery("SELECT DISTINCT(c.nombre) FROM Cliente c", String.class)
                .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("\n==== consulta con formas de pago unicas =====");
        List<String> formasPago = em.createQuery("SELECT DISTINCT(c.formaPago) FROM Cliente c", String.class)
                .getResultList();
        formasPago.forEach(System.out::println);

        System.out.println("\n===== consulta con numero de formas de pago unicas ======");
        Long totalFormasPago = em.createQuery("SELECT COUNT(DISTINCT c.formaPago) FROM Cliente c", Long.class)
                .getSingleResult();
        System.out.println(totalFormasPago);

        System.out.println("\n===== consulta con nombre y apellido concatenados =======");
        /*nombres = em.createQuery("SELECT CONCAT(c.nombre, ' ', c.apellido) AS nombreCompleto FROM Cliente c", String.class)
                .getResultList();
        nombres.forEach(System.out::println);*/

        nombres = em.createQuery("SELECT c.nombre || ' ' || c.apellido AS nombreCompleto FROM Cliente c", String.class)
                .getResultList();

        nombres.forEach(System.out::println);

        System.out.println("\n=== consulta con nombre y apellido concatenados en mayuscula ========");
        nombres = em.createQuery("SELECT UPPER(CONCAT(c.nombre, ' ', c.apellido)) AS nombreCompleto FROM Cliente c", String.class)
                .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("\n====== consulta para buscar por nombre ======");
        String param = "NA";
        clientes = em.createQuery("SELECT c FROM Cliente c WHERE UPPER(c.nombre) LIKE UPPER(:parametro)", Cliente.class)
                .setParameter("parametro", "%" + param + "%")
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("\n==== consultas por rangos =====");
        //clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.id BETWEEN 2 AND 5", Cliente.class).getResultList();
        clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.nombre BETWEEN 'J' AND 'Q'", Cliente.class).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("\n====== consulta con orden ======");
        clientes = em.createQuery("select c from Cliente c order by c.nombre asc, c.apellido asc",
                Cliente.class).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("\n====== consulta con total de registros de la tabla ======");
        Long total = em.createQuery("select count (c) as total from Cliente c", Long.class)
                .getSingleResult();
        System.out.println(total);

        System.out.println("\n====== consulta con valor minimo del id ======");
        Long minId = em.createQuery("select min(c.id) as maximo from Cliente c",
                Long.class).getSingleResult();
        System.out.println(minId);

        System.out.println("\n====== consulta con max / ultimo id ======");
        Long maxId = em.createQuery("select max(c.id) as maximo from Cliente c",
                Long.class).getSingleResult();
        System.out.println(maxId);

        System.out.println("\n====== consulta con nombre y su largo ======");
        registros = em.createQuery("select c.nombre, length(c.nombre) from Cliente c", Object[].class)
                .getResultList();
        registros.forEach(reg -> {
            String nom = (String) reg[0];
            Integer largo = (Integer) reg[1];
            System.out.println("nombre: " + nom + ", largo:" + largo);
        });

        System.out.println("\n====== consulta con el nombre mas corto ======");
        Integer maxLargoNombre = em.createQuery("select max(length(c.nombre))" +
                "from Cliente c", Integer.class).getSingleResult();
        System.out.println(maxLargoNombre);

        System.out.println("\n====== consultas resumen funciones agregaciones count min max avg sum ======");
        Object[] estadisticas = em.createQuery("select min(c.id), max(c.id), sum(c.id), count(c.id), avg(length(c.nombre)) from Cliente c", Object[].class)
                .getSingleResult();
        Long min = (Long) estadisticas[0];
        Long max = (Long) estadisticas[1];
        Long sum = (Long) estadisticas[2];
        Long count = (Long) estadisticas[3];
        Double avg = (Double) estadisticas[4];
        System.out.println("min: "+ min + ", max: " + max + ", sum: " + sum + ", count: " + count + ", avg: " + avg);

        System.out.println("\n====== consulta con el nombre mas corto y mas largo ======");
        registros = em.createQuery("select c.nombre, length(c.nombre) from Cliente c where " +
                "length(c.nombre) = (select min(length(c.nombre)) from Cliente c)", Object[].class)
                .getResultList();
        registros.forEach(reg -> {
            String nom = (String) reg[0];
            Integer largo = (Integer) reg[1];
            System.out.println("nombre: " + nom + ", largo: " + largo);
        });

        System.out.println("\n====== consulta para obtener el ultimo registro ======");
        Cliente ultimoCliente = em.createQuery("select c from Cliente c where c.id = (select max(c.id) from Cliente c)", Cliente.class)
                .getSingleResult();
        System.out.println(ultimoCliente);

        System.out.println("\n====== consulta where in ======");
        clientes = em.createQuery("select c from Cliente c where c.id in :ids",Cliente.class)
                .setParameter("ids", Arrays.asList(1L,2L,10L,6L))
                .getResultList();
        clientes.forEach(System.out::println);
        em.close();
    }
}

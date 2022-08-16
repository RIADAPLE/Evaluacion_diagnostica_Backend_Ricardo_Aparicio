package org.example;

import org.example.dao.Conexion;
import org.example.dto.Departamento;
import org.example.dto.Empleado;
import org.example.util.DepartamentoRepositorioImpl;
import org.example.util.EmpleadoRepositorioImpl;
import org.example.util.Repositorio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        try (Connection conn = Conexion.getConnection()) {
            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }
            try {
                int op1 = 0;
                Repositorio<Empleado> repositorioEmp = new EmpleadoRepositorioImpl(conn);
                Repositorio<Departamento> repositorioDep = new DepartamentoRepositorioImpl(conn);
                do{
                    menu();
                    op1 = scan.nextInt(); scan.nextLine();
                    switch (op1){
                        case 1:
                            System.out.println("========== listar empleado ==========");
                            repositorioEmp.listar().forEach(System.out::println);
                            break;
                        case 2:
                            System.out.println("========== listar departamento ==========");
                            repositorioDep.listar().forEach(System.out::println);
                            break;
                        case 3:
                            System.out.println("Introduzca los siguientes campos:");

                            System.out.println("Nombre:");
                            String nombre = scan.nextLine();

                            System.out.println("Apellido:");
                            String apellido = scan.nextLine();

                            System.out.println("Direccion:");
                            String direccion = scan.nextLine();

                            System.out.println("Correo:");
                            String correo = scan.nextLine();

                            System.out.println("Id del departamento al que pertenece:");
                            int idDepartamento = scan.nextInt(); scan.nextLine();

                            Departamento nuevoDep = repositorioDep.porId(idDepartamento);

                            Empleado creadoEmp = repositorioEmp.guardarActualizar(new Empleado(nombre,apellido,direccion,correo,nuevoDep));

                            System.out.println("Empleado creado! id: " + creadoEmp.getId() + " nombre: " + creadoEmp.getNombre());
                            break;
                        case 4:
                            System.out.println("Introduzca los siguientes campos:");

                            System.out.println("Nombre del departamento:");
                            String nombreDep = scan.nextLine();

                            Departamento creadoDep = repositorioDep.guardarActualizar(new Departamento(nombreDep));

                            System.out.println("Departamento creado! id: " + creadoDep.getId() + " nombre: " + creadoDep.getNombre());
                            break;
                        case 5:
                            System.out.println("Introduzca los siguientes campos:");

                            System.out.println("id:");
                            int idEmp = scan.nextInt(); scan.nextLine();

                            System.out.println("Nombre:");
                            String nombreAct = scan.nextLine();

                            System.out.println("Apellido:");
                            String apellidoAct = scan.nextLine();

                            System.out.println("Direccion:");
                            String direccionAct = scan.nextLine();

                            System.out.println("Correo:");
                            String correoAct = scan.nextLine();

                            System.out.println("Id del departamento al que pertenece:");
                            int idDepartamentoAct = scan.nextInt(); scan.nextLine();

                            Departamento nuevoDepAct = repositorioDep.porId(idDepartamentoAct);

                            Empleado actualizadoEmp = repositorioEmp.guardarActualizar(new Empleado(idEmp,nombreAct,apellidoAct,direccionAct,correoAct,nuevoDepAct));

                            System.out.println("Empleado actualizado! id: " + actualizadoEmp.getId() + " nombre: " + actualizadoEmp.getNombre());
                            break;
                        case 6:
                            System.out.println("Introduzca los siguientes campos:");

                            System.out.println("id");
                            int idDep = scan.nextInt(); scan.nextLine();

                            System.out.println("Nombre del departamento:");
                            String nombreDepAct = scan.nextLine();

                            Departamento actualizadoDep = repositorioDep.guardarActualizar(new Departamento(idDep,nombreDepAct));

                            System.out.println("Departamento creado! id: " + actualizadoDep.getId() + " nombre: " + actualizadoDep.getNombre());
                            break;
                        case 7:
                            System.out.println("Introduzca los siguientes campos:");

                            System.out.println("id");
                            int idEmpEl = scan.nextInt(); scan.nextLine();

                            repositorioEmp.eliminar(idEmpEl);

                            System.out.println("Empleado eliminado!");
                            break;
                        case 8:
                            System.out.println("Introduzca los siguientes campos:");

                            System.out.println("id");
                            int idDepEl = scan.nextInt(); scan.nextLine();

                            repositorioDep.eliminar(idDepEl);

                            System.out.println("Departamento eliminado!");
                            break;
                        case 0:
                            System.out.println("Hasta la próxima");
                            break;
                        default:
                            System.out.println("Opcion invalida!");
                            break;
                    }
                    conn.commit();
                }while(op1!=0);

            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
            catch (InputMismatchException e) {
                System.out.println("El formato introducido no fue el adecuado");
                conn.rollback();
                e.printStackTrace();
            }
        }
    }

    public static void menu(){
        System.out.println("1. Ver empleados");
        System.out.println("2. Ver departamentos");
        System.out.println("3. Agregar empleado");
        System.out.println("4. Agregar departamento");
        System.out.println("5. Actualizar empleado");
        System.out.println("6. Actualizar departamento");
        System.out.println("7. Eliminar empleado");
        System.out.println("8. Eliminar departamento");
        System.out.println("0. Salir");
    }
}
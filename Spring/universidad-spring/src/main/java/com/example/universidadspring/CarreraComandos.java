package com.example.universidadspring;

import com.example.universidadspring.modelo.entidades.Carrera;
import com.example.universidadspring.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarreraComandos implements CommandLineRunner {
    @Autowired
    private CarreraDAO servicio;
    @Override
    public void run(String... args) throws Exception {
        /*Carrera ingSistemas = new Carrera(null, "Ingenieria en Sistemas",50,5);
        Carrera ingIndustrial = new Carrera(null, "Ingenieria Industrial",55,5);
        Carrera ingAlimentos = new Carrera(null, "Ingenieria en alimentos",53,5);
        Carrera ingElectronica = new Carrera(null, "Ingenieria electronica",45,5);
        Carrera licSistemas = new Carrera(null, "Licenciatura en Sistemas",40,5);
        Carrera licCienciaDatos= new Carrera(null, "Licenciatura en ciencia de datos",42,4);
        Carrera licAdminEmp = new Carrera(null, "Licenciatura en administracion de empresas",25,3);
        Carrera licIdiomas = new Carrera(null, "Licenciatura en Idiomas",33,3);

        servicio.save(ingSistemas);
        servicio.save(ingIndustrial);
        servicio.save(ingAlimentos);
        servicio.save(ingElectronica);
        servicio.save(licSistemas);
        servicio.save(licCienciaDatos);
        servicio.save(licAdminEmp);
        servicio.save(licIdiomas);*/

        /*System.out.println("\n------ Buscando sistemas ------");
        List<Carrera> carreras = (List<Carrera>) servicio.findCarreraByNombreContains("Sistemas");
        carreras.forEach(System.out::println);

        System.out.println("\n------ Ignorando mayusculas ingenieria ------");
        List<Carrera> carrerasIgnoreCase = (List<Carrera>) servicio.findCarreraByNombreContainsIgnoreCase("ingenieria");
        carrerasIgnoreCase.forEach(System.out::println);

        System.out.println("\n------ Por cantidad de anios 5 ------");
        List<Carrera> carrerasCantidadAnios = (List<Carrera>) servicio.findCarreraByCantidadAnios(5);
        carrerasCantidadAnios.forEach(System.out::println);*/

        System.out.println("\n------ Find carrera by Nombre y apellido ------");
        List<Carrera> carrerasCantidadAnios = (List<Carrera>) servicio.buscarCarrerasPorProfesorNombreYApellido("Ricardo","Aparicio");
        System.out.println();
        carrerasCantidadAnios.forEach(System.out::println);
    }
}

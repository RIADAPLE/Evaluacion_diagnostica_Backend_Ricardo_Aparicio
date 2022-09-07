package com.example.universidadspring;

import com.example.universidadspring.modelo.entidades.Alumno;
import com.example.universidadspring.modelo.entidades.Carrera;
import com.example.universidadspring.modelo.entidades.Persona;
import com.example.universidadspring.servicios.contratos.AlumnoDAO;
import com.example.universidadspring.servicios.contratos.CarreraDAO;
import com.example.universidadspring.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AlumnosCommand implements CommandLineRunner {
    @Autowired
    @Qualifier("alumnoDAOimpl")
    private PersonaDAO personaDAO;
    @Autowired
    private CarreraDAO carreraDAO;

    @Override
    public void run(String... args) throws Exception {


        Iterable<Persona> alumnos = personaDAO.findAll();
        /*alumnos.forEach(alumno ->((Alumno)alumno).setCarrera(ingSistemas.get()));
        alumnos.forEach(alumno -> personaDAO.save(alumno));*/

        /*Optional<Persona> alumno_1 = personaDAO.findById(1);
        Optional<Persona> personaNomApe = personaDAO.buscaPorNombreYApellido(alumno_1.get().getNombre(), alumno_1.get().getApellido());
        System.out.println(personaNomApe.toString());

        Optional<Persona> personaDni = personaDAO.buscarPorDni(alumno_1.get().getDni());
        System.out.println(personaDni.toString());

        Iterable<Persona> personasApellido = personaDAO.buscarPersonaPorApellido(alumno_1.get().getApellido());
        personasApellido.forEach(System.out::println);*/
        /*Optional<Carrera> ingSistemas = carreraDAO.findById(2);
        Iterable<Persona> alumnoCarrera = ((AlumnoDAO)personaDAO).buscarAlumnosPorNombreCarrera(ingSistemas.get().getNombre());
        alumnoCarrera.forEach(System.out::println);*/
    }
}

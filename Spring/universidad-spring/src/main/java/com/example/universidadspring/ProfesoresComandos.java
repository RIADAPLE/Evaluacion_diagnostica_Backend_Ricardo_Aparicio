package com.example.universidadspring;

import com.example.universidadspring.modelo.entidades.Carrera;
import com.example.universidadspring.modelo.entidades.Direccion;
import com.example.universidadspring.modelo.entidades.Persona;
import com.example.universidadspring.modelo.entidades.Profesor;
import com.example.universidadspring.servicios.contratos.AlumnoDAO;
import com.example.universidadspring.servicios.contratos.CarreraDAO;
import com.example.universidadspring.servicios.contratos.PersonaDAO;
import com.example.universidadspring.servicios.contratos.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class ProfesoresComandos implements CommandLineRunner {
    @Autowired
    @Qualifier("profesorDAOimpl")
    private PersonaDAO personaDAO;
    @Autowired
    private CarreraDAO carreraDAO;

    @Override
    public void run(String... args) throws Exception {
        /*Direccion direccion = new Direccion("col Jardines","745","000000","La libertad","2","Santa Tecla");
        Profesor profesor = new Profesor(null,"Francisco","Melgar","33333333",direccion, new BigDecimal(String.valueOf(2500)));
        Optional<Carrera> ingSistemas = carreraDAO.findById(2);
        Carrera newCarrera = new Carrera(ingSistemas.get().getId(),ingSistemas.get().getNombre(),ingSistemas.get().getCantidadMaterias(),ingSistemas.get().getCantidadAnios());
        Set<Carrera> carreraSet = new HashSet<>();
        carreraSet.add(newCarrera);
        profesor.setCarreras(carreraSet);
        Persona save = personaDAO.save(profesor);
        System.out.println(save.toString());*/

        /*Optional<Carrera> ingSistemas = carreraDAO.findById(2);
        Iterable<Persona> profesorCarrera = ((ProfesorDAO)personaDAO).findProfesoresByCarrera(ingSistemas.get().getNombre());
        profesorCarrera.forEach(System.out::println);*/
    }
}

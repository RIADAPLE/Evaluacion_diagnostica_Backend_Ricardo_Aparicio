package com.example.universidadspring;

import com.example.universidadspring.modelo.entidades.Alumno;
import com.example.universidadspring.modelo.entidades.Direccion;
import com.example.universidadspring.modelo.entidades.Persona;
import com.example.universidadspring.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UniversidadSpringApplication {
    @Autowired
    private AlumnoDAO servicio;
    public static void main(String[] args) {
        String[] beanDefinitionNames = SpringApplication.run(UniversidadSpringApplication.class, args).getBeanDefinitionNames();
        /*for(String str : beanDefinitionNames){
            System.out.println(str);
        }*/
    }

    @Bean
    public CommandLineRunner runner(){
        return args -> {
            /*Direccion direccion = new Direccion("col Jardines","745","000000","La libertad","2","Santa Tecla");
            Persona alumno = new Alumno(null,"Francisco","Melgar","22222222",direccion);
            Persona save = servicio.save(alumno);
            System.out.println(save.toString());*/

           /* List<Persona> alumnos = (List<Persona>) servicio.findAll();
            alumnos.forEach(System.out::println);*/
        };
    }

}

package com.example.universidadspring;

import com.example.universidadspring.modelo.entidades.Direccion;
import com.example.universidadspring.modelo.entidades.Empleado;
import com.example.universidadspring.modelo.entidades.Persona;
import com.example.universidadspring.modelo.entidades.enumeradores.TipoEmpleado;
import com.example.universidadspring.servicios.contratos.EmpleadoDAO;
import com.example.universidadspring.servicios.contratos.PersonaDAO;
import com.example.universidadspring.servicios.contratos.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class EmpleadoComandos implements CommandLineRunner {
    @Autowired
    @Qualifier("empleadoDAOimpl")
    private PersonaDAO personaDAO;

    @Override
    public void run(String... args) throws Exception {
        /*Direccion direccion = new Direccion("col Jardines","745","000000","La libertad","2","Santa Tecla");
        Persona empleado = new Empleado(null,"Josu","Ramirez","33333333",direccion,new BigDecimal(String.valueOf(2500)), TipoEmpleado.ADMINISTRATIVO);
        Persona save = personaDAO.save(empleado);
        System.out.println(save.toString());*/
        Iterable<Persona> empleadoEnum = ((EmpleadoDAO)personaDAO).findEmpleadoByTipoEmpleado(TipoEmpleado.ADMINISTRATIVO);
        empleadoEnum.forEach(System.out::println);
    }
}

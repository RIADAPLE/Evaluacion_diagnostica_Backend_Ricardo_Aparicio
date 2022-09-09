package com.example.universidadspring;

import com.example.universidadspring.modelo.entidades.Direccion;
import com.example.universidadspring.modelo.entidades.Pabellon;
import com.example.universidadspring.modelo.entidades.Persona;
import com.example.universidadspring.modelo.entidades.enumeradores.TipoEmpleado;
import com.example.universidadspring.servicios.contratos.EmpleadoDAO;
import com.example.universidadspring.servicios.contratos.PabellonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class PabellonComandos implements CommandLineRunner {
    @Autowired
    private PabellonDAO pabellonDAO;

    @Override
    public void run(String... args) throws Exception {
        Direccion direccion = new Direccion("col Lomas de miralvalle","800","000000","San salvador","2","San Salvador");
        Pabellon pabellon = new Pabellon(null,200d,"PasilloB",direccion);
        pabellonDAO.save(pabellon);
        System.out.println("---------- Find pabellon by direccion calle");
        Iterable<Pabellon> pabellonEnum = pabellonDAO.findPabellonByDireccion_Calle("col Lomas de miralvalle");
        pabellonEnum.forEach(System.out::println);
        System.out.println();
    }
}

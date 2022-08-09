package test;

import dto.PersonaDTO;
import jdbc.PersonaDao;
import jdbc.PersonaDaoJDBC;

import java.sql.SQLException;
import java.util.List;

public class TestPersonas {
    public static void main(String[] args) {
        //Utilizamoss el tipo interface como referencia
        //a una clase concreta
        PersonaDao personaDao = new PersonaDaoJDBC();

        //Creamos un nuevo registro
        //Hacemos uso de la clase persona DTO la cual se usa
        //para transferir la información entre las capas
        PersonaDTO persona = new PersonaDTO();
        persona.setNombre("mario");
        persona.setApellido("lopez01");
        //Utilizamos la capa DAO para persistir el objeto DTO
        try{
            personaDao.insert(persona);

            //eliminamos un registro, el id 3
            //actualizamos un registro
            PersonaDTO personaTmp = new PersonaDTO();
            personaTmp.setId_persona(2);
            personaTmp.setNombre("Mario");
            personaTmp.setApellido("lopez02");
            personaDao.update(personaTmp);

            List<PersonaDTO> personas = personaDao.select();
            for (PersonaDTO personaDTO: personas) {
                System.out.print(personaDTO);
                System.out.println();
            }
        } catch (SQLException e){
            System.out.println("Excepcion en la capa de prueba");
            e.printStackTrace();
        }
    }
}

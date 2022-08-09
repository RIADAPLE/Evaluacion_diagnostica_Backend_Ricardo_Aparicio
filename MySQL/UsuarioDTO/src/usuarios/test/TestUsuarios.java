package usuarios.test;

import usuarios.dto.UsuarioDTO;
import usuarios.jdbc.UsuarioDao;
import usuarios.jdbc.UsuarioDaoJDBC;

import java.sql.SQLException;
import java.util.List;

public class TestUsuarios {
    public static void main(String[] args) {
        //Utilizamoss el tipo interface como referencia
        //a una clase concreta
        UsuarioDao usuarioDao = new UsuarioDaoJDBC();

        //Creamos un nuevo registro
        //Hacemos uso de la clase persona DTO la cual se usa
        //para transferir la información entre las capas
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setUsuario("mario");
        usuario.setPassword("lopez01");
        usuario.setEmail("mario@gmail.com");

        UsuarioDTO usuario1 = new UsuarioDTO();
        usuario1.setUsuario("Ricardo");
        usuario1.setPassword("Aparicio01");
        usuario1.setEmail("raparicio@gmail.com");
        //Utilizamos la capa DAO para persistir el objeto DTO
        try{
            usuarioDao.insert(usuario);
            //usuarioDao.insert(usuario1);

            //eliminamos un registro, el id 3
            //actualizamos un registro
           /* UsuarioDTO usuarioTmp = new UsuarioDTO();
            usuarioTmp.setId_usuario(2);
            usuarioTmp.setUsuario("Mario");
            usuarioTmp.setPassword("lopez02");
            usuarioTmp.setEmail("lopez2@gmail.com");
            usuarioDao.update(usuarioTmp);*/
            UsuarioDTO usuarioEliminar = new UsuarioDTO();
            usuarioEliminar.setId_usuario(3);
            usuarioDao.delete(usuarioEliminar);

            List<UsuarioDTO> usuarios = usuarioDao.select();
            for (UsuarioDTO usuarioDTO: usuarios) {
                System.out.print(usuarioDTO);
                System.out.println();
            }
        } catch (SQLException e){
            System.out.println("Excepcion en la capa de prueba");
            e.printStackTrace();
        }
    }
}


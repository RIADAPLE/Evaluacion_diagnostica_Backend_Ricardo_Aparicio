package manejopersonas;

import datos.Conexion;
import datos.PersonasJDBC;
import domain.Persona;

import java.sql.Connection;
import java.sql.SQLException;

public class ManejoPersonas {
    public static void main(String[] args) {
        PersonasJDBC personasJDBC = new PersonasJDBC();

        Connection conn = null;

        try {
            conn = Conexion.getConnection();
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }

            PersonasJDBC personas = new PersonasJDBC(conn);

            personas.update(2, "Regreso2", "Regreso");

            personas.insert("Miguel2","Ayala32132132132132132132132132132132132131231232132132132123");
            conn.commit();
        } catch (SQLException e){
            try {
                System.out.println("Entramos el rollback");

                e.printStackTrace(System.out);

                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace(System.out);
            }
        }
    }
}

package jdbc;

import dto.PersonaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDaoJDBC implements PersonaDao {

    private java.sql.Connection userConn;

    private final String SQL_INSERT = "INSERT INTO persona (nombre, apellido) VALUES (?,?)";

    private final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=? WHERE id_persona=?";

    private final String SQL_DELETE = "DELETE FROM persona WHERE id_persona=?";

    private final String SQL_SELECT = "SELECT id_persona, nombre, apellido FROM persona ORDER BY id_persona";

    public PersonaDaoJDBC(){

    }


    public PersonaDaoJDBC(Connection conn){
        this.userConn = conn;
    }

    @Override
    public int insert(PersonaDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setString(index++, persona.getNombre());
            stmt.setString(index++, persona.getApellido());
            System.out.println("Ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        } finally {
            Conexion.close(stmt);
            if(this.userConn== null){
                Conexion.close(conn);
            }
        }
        return rows;
    }

    @Override
    public int update(PersonaDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            System.out.println("Ejectutando query: "+ SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, persona.getNombre());
            stmt.setString(index++, persona.getApellido());
            stmt.setInt(index, persona.getId_persona());
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados: " + rows);
        } finally {
            Conexion.close(stmt);
            if(this.userConn== null){
                Conexion.close(conn);
            }
        }
        return rows;
    }

    @Override
    public int delete(PersonaDTO persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            System.out.println("Ejectutando query: "+ SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1,persona.getId_persona());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } finally {
            Conexion.close(stmt);
            if(this.userConn== null){
                Conexion.close(conn);
            }
        }
        return rows;
    }

    @Override
    public List<PersonaDTO> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PersonaDTO persona = null;
        List<PersonaDTO> personas = new ArrayList<>();
        try {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()) {
                int id_persona = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                /*System.out.print(" " + id_persona);
                System.out.print(" " + nombre);
                System.out.print(" " + apellido);
                System.out.println();*/
                persona = new PersonaDTO();
                persona.setId_persona(id_persona);
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                personas.add(persona);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn== null){
                Conexion.close(conn);
            }
        }
        return personas;
    }
}

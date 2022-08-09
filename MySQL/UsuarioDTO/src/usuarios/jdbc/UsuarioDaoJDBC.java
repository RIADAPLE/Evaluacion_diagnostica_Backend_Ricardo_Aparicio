package usuarios.jdbc;

import usuarios.dto.UsuarioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoJDBC implements UsuarioDao {

    private java.sql.Connection userConn;

    private final String SQL_INSERT = "INSERT INTO usuario (usuario, password, email) VALUES (?,?,?)";

    private final String SQL_UPDATE = "UPDATE usuario SET usuario=?, password=?, email=? WHERE id_usuario=?";

    private final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario=?";

    private final String SQL_SELECT = "SELECT id_usuario, usuario, password, email FROM usuario ORDER BY id_usuario";

    public UsuarioDaoJDBC(){

    }


    public UsuarioDaoJDBC(Connection conn){
        this.userConn = conn;
    }

    @Override
    public int insert(UsuarioDTO usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setString(index++, usuario.getUsuario());
            stmt.setString(index++, usuario.getPassword());
            stmt.setString(index++, usuario.getEmail());
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
    public int update(UsuarioDTO usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            System.out.println("Ejectutando query: "+ SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, usuario.getUsuario());
            stmt.setString(index++, usuario.getPassword());
            stmt.setString(index++, usuario.getEmail());
            stmt.setInt(index, usuario.getId_usuario());
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
    public int delete(UsuarioDTO usuario) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            System.out.println("Ejectutando query: "+ SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1,usuario.getId_usuario());
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
    public List<UsuarioDTO> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioDTO usuario = null;
        List<UsuarioDTO> usuarios = new ArrayList<>();
        try {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()) {
                int id_usuario = rs.getInt(1);
                String usuarioN = rs.getString(2);
                String password = rs.getString(3);
                String email = rs.getString(4);
                /*System.out.print(" " + id_persona);
                System.out.print(" " + nombre);
                System.out.print(" " + apellido);
                System.out.println();*/
                usuario = new UsuarioDTO();
                usuario.setId_usuario(id_usuario);
                usuario.setUsuario(usuarioN);
                usuario.setPassword(password);
                usuario.setEmail(email);
                usuarios.add(usuario);
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
        return usuarios;
    }
}


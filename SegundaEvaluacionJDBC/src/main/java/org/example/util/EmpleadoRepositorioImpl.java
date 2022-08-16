package org.example.util;

import org.example.dto.Departamento;
import org.example.dto.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepositorioImpl implements Repositorio<Empleado>{

    private Connection conn;

    public EmpleadoRepositorioImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Empleado> listar() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT e.*, d.nombre as departamento FROM empleados as e " +
                     "inner join departamentos as d ON (e.departamento_id = d.id)")){
            while (rs.next()){
                Empleado e = crearEmpleado(rs);
                empleados.add(e);
            }
        }
        return empleados;
    }

    @Override
    public Empleado porId(int id) throws SQLException {
        Empleado empleado = null;

        try(PreparedStatement stmt = conn.prepareStatement("SELECT e.*, d.nombre as departamento " +
                "FROM empleados as e " +
                "inner join departamentos as d ON (e.departamento_id = d.id) WHERE e.id = ?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    empleado = crearEmpleado(rs);
                }
            }
        }
        return empleado;
    }

    @Override
    public Empleado guardarActualizar(Empleado empleado) throws SQLException {
        String sql;
        if(empleado.getId()>0) {
            sql = "UPDATE empleados SET nombre = ?, apellido = ?, direccion = ?, correo = ?, departamento_id = ? WHERE id = ?";
        } else {
            sql = "INSERT INTO empleados(nombre, apellido, direccion, correo, departamento_id) VALUES(?,?,?,?,?)";
        }
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getApellido());
            stmt.setString(3, empleado.getDireccion());
            stmt.setString(4, empleado.getCorreo());
            stmt.setLong(5, empleado.getDepartamento().getId());

            if (empleado.getId() > 0) {
                stmt.setLong(6, empleado.getId());
            } 
            stmt.executeUpdate();

            if(empleado.getId() == 0){
                try(ResultSet rs = stmt.getGeneratedKeys()){
                    if(rs.next()){
                        empleado.setId(rs.getInt(1));
                    }
                }
            }
            return empleado;
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM empleados WHERE id=?")) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private Empleado crearEmpleado(ResultSet rs) throws SQLException {
        Empleado e = new Empleado();
        e.setId(rs.getInt("id"));
        e.setNombre(rs.getString("nombre"));
        e.setApellido(rs.getString("apellido"));
        e.setDireccion(rs.getString("direccion"));
        e.setCorreo(rs.getString("correo"));
        Departamento departamento = new Departamento();
        departamento.setId(rs.getInt("departamento_id"));
        departamento.setNombre(rs.getString("departamento"));
        e.setDepartamento(departamento);
        return e;
    }
}

package org.example.util;

import org.example.dto.Departamento;
import org.example.dto.Departamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoRepositorioImpl implements Repositorio<Departamento> {

    private Connection conn;

    public DepartamentoRepositorioImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Departamento> listar() throws SQLException {
        List<Departamento> departamentos = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM departamentos")){
            while (rs.next()){
                Departamento e = crearDepartamento(rs);
                departamentos.add(e);
            }
        }
        return departamentos;
    }

    @Override
    public Departamento porId(int id) throws SQLException {
        Departamento departamento = null;

        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM departamentos as d WHERE d.id=?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    departamento = crearDepartamento(rs);
                }
            }
        }
        return departamento;
    }

    @Override
    public Departamento guardarActualizar(Departamento departamento) throws SQLException {
        String sql;
        if(departamento.getId()>0) {
            sql = "UPDATE departamentos SET nombre = ? WHERE id = ?";
        } else {
            sql = "INSERT INTO departamentos(nombre) VALUES(?)";
        }
        try (PreparedStatement stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1,departamento.getNombre());
            if(departamento.getId()>0){
                stmt.setLong(2,departamento.getId());
            }
            stmt.executeUpdate();
            if(departamento.getId() == 0){
                try(ResultSet rs = stmt.getGeneratedKeys()){
                    if(rs.next()){
                        departamento.setId(rs.getInt(1));
                    }
                }
            }
            return departamento;
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM departamentos WHERE id=?")) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private Departamento crearDepartamento(ResultSet rs) throws SQLException {
        Departamento d = new Departamento();
        d.setId(rs.getInt("id"));
        d.setNombre(rs.getString("nombre"));
        return d;
    }
}

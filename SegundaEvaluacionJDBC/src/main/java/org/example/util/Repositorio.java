package org.example.util;

import java.sql.SQLException;
import java.util.List;

public interface Repositorio<T> {

    List<T> listar() throws SQLException;

    T porId(int id) throws SQLException;

    T guardarActualizar(T t) throws SQLException;

    void eliminar(int id) throws SQLException;
}

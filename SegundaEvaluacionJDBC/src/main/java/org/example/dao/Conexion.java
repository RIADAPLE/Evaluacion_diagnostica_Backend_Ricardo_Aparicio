package org.example.dao;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Conexion {
    private static String url = "jdbc:mysql://localhost/RH?serverTimezone=America/El_Salvador";

    private static String username = "root";

    private static String password = "pass123";

    private static BasicDataSource pool;

    public static BasicDataSource getInstance() throws SQLException {
        if(pool == null) {
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(username);
            pool.setPassword(password);
            pool.setInitialSize(3);
            pool.setMinIdle(3);
            pool.setMinIdle(8);
            pool.setMaxTotal(8);
        }
        return pool;
    }

    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }
}

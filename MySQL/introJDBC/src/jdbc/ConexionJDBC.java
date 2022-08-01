package jdbc;

import java.sql.*;


public class ConexionJDBC {
    public static void main(String[] args) {
        //Cadena de conexión Mysql, el parámetro use SSL es opcional
        String url="jdbc:mysql://localhost:3306/sga?useSSL=false";
        //Cargamos el driver de mysql
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Creamos el objeto conexion
            Connection conexion=(Connection) DriverManager.getConnection(url,"root","pass123");
            //Creamos un objeto Statement
            Statement instruccion=conexion.createStatement();
            //Creamos el query
            String sql="select id_persona, nombre, apellido from persona";
            ResultSet result = instruccion.executeQuery(sql);
            while(result.next()) {
                System.out.println("\n Id: " + result.getInt(1));
                System.out.println(" Nombre: " + result.getString(2));
                System.out.println(" Apellido: " + result.getString(3));
            }
            //Cerrar cada uno de los objetos utilizados
            result.close();
            instruccion.close();
            conexion.close();
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

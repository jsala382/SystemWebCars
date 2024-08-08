package org.jsalaza.apiservlet.webappheaders.conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/db_concesionario?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static Connection connexionBAD;

    public ConnexionBD() {
    }

    public static Connection getConnection() {
        if (connexionBAD == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connexionBAD = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            } catch (SQLException var1) {
                SQLException e = var1;
                throw new RuntimeException("ERROR AL CONECTARSE A LA BASE DE DATOS " + e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("ERROR AL CARGAR EL DRIVER " + e);
            }
        }

        return connexionBAD;
    }
}
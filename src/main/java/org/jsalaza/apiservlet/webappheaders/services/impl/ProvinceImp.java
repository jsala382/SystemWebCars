package org.jsalaza.apiservlet.webappheaders.services.impl;

import org.jsalaza.apiservlet.webappheaders.conexion.ConnexionBD;
import org.jsalaza.apiservlet.webappheaders.modelo.Color;
import org.jsalaza.apiservlet.webappheaders.modelo.Provinces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProvinceImp {
    public void saveProvinces(Provinces provinces) {
        String sql = "insert into db_concesionario.provincia (nombre)  VALUES(?)";
        try {
            Connection conn = ConnexionBD.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,provinces.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar un registro de la tabla provincia "+ e);
        }
        System.out.println("Provincia insertado correctamente");
    }
}

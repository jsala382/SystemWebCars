package org.jsalaza.apiservlet.webappheaders.services.impl;

import org.jsalaza.apiservlet.webappheaders.conexion.ConnexionBD;
import org.jsalaza.apiservlet.webappheaders.modelo.Color;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ColorImp implements ColorInterface{
    @Override
    public void saveColor(Color color) {
        String sql = "insert into db_concesionario.color (tono,id_vehiculo)  VALUES(?,?)";
        try {
            Connection conn = ConnexionBD.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, color.getTone());
            ps.setInt(2, color.getIdCar());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar un registro de la tabla color "+ e);
        }
        System.out.println("Color insertado correctamente");
    }
}

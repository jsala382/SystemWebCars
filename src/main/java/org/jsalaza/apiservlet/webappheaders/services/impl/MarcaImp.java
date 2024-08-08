package org.jsalaza.apiservlet.webappheaders.services.impl;

import org.jsalaza.apiservlet.webappheaders.conexion.ConnexionBD;
import org.jsalaza.apiservlet.webappheaders.modelo.Marca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MarcaImp implements MarcaInterface {
    @Override
    public void saveMarca(Marca marca) {
        String sql = "insert into db_concesionario.marca (nombre, id_vehiculo)  VALUES(?,?)";
        try {
            Connection conn = ConnexionBD.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, marca.getNombre());
            ps.setInt(2, marca.getId_vehiculo());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar un registro de la tabla marca " + e);
        }
        System.out.println("Vehiculo insertado correctamente");
    }
}

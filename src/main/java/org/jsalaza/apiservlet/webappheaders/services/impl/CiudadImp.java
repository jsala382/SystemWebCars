package org.jsalaza.apiservlet.webappheaders.services.impl;

import org.jsalaza.apiservlet.webappheaders.conexion.ConnexionBD;
import org.jsalaza.apiservlet.webappheaders.modelo.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CiudadImp {
    public int getIndexCity() {
        int indice = 0;
        String sql = " SELECT max(id_ciudad) as MAX FROM db_concesionario.ciudad;";
        try {
            Connection con = ConnexionBD.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                indice = rs.getInt("MAX");
            }

        } catch (SQLException e) {
            throw new RuntimeException("ERROR AL OBTENER EL INDICE" + e);
        }
        return indice;
    }


}

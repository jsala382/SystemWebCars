package org.jsalaza.apiservlet.webappheaders.services.impl;

import org.jsalaza.apiservlet.webappheaders.conexion.ConnexionBD;
import org.jsalaza.apiservlet.webappheaders.modelo.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClientImp implements ClientInterface {
    @Override
    public void saveClient(Client client) {
        String sql = "insert into db_concesionario.cliente (cedula, nombres,genero,estado_civil,tipo_documento,direccion, telefono,id_provincia,id_ciudad) " +
                "VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            Connection connection = ConnexionBD.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, client.getIdentificationCard());
            ps.setString(2, client.getName());
            ps.setString(3, client.getGender());
            ps.setString(4, client.getCivilStatus());
            ps.setString(5, client.getTypeDocuments());
            ps.setString(6, client.getAddress());
            ps.setString(7, client.getPhones());
            ps.setInt(8, client.getIdProvinces());
            ps.setInt(9, client.getIdCity());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("ERROR AL INSERTAR UN CAMPO EN LA TABLA CLIENTE" + e);
        }
        System.out.println("El cliente fue insertado correctamente");
    }

    @Override
    public int getIndexClient() {
        int indice = 0;
        String sql = " SELECT max(id) as MAX FROM db_concesionario.cliente;";
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

    @Override
    public List<Client> getClientByProinces(String provinces) {
        return List.of();
    }
}

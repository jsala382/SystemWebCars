package org.jsalaza.apiservlet.webappheaders.services.impl;

import org.jsalaza.apiservlet.webappheaders.conexion.ConnexionBD;
import org.jsalaza.apiservlet.webappheaders.modelo.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarImp implements CarInterface {

    @Override
    public void saveCar(Car car)
    {
        String sql = "insert into db_concesionario.vehiculo (placa,matricula)    VALUES(?,?)";
        try {
            Connection conn = ConnexionBD.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, car.getPlate());
            ps.setString(2, car.getRegistrationNumber());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar un registro de la tabla  vehculo "+ e);
        }
        System.out.println("Vehiculo insertado correctamente");

    }

   public int maxIndexHeader() {
        int indice = 0;
        try {
            Connection connection = ConnexionBD.getConnection();
            String sql = " SELECT max(ID) as MAX FROM db_concesionario.vehiculo;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                indice = result.getInt("MAX");
            }

        } catch (SQLException e) {
            throw new RuntimeException("ERROr AL OBTENER EL INDCE" +e);
        }
        return indice;
    }


    @Override
    public List<Car> getCarByColor(String color) {
                return null;
    }

    @Override
    public void deleteCarById(String id) {

    }

    @Override
    public List<Car> getCarByPlate(String plate) {
        List<Car> listCar=new ArrayList<>();
        String sql ="SELECT veh.id,  veh.matricula,co.tono,marc.nombre \n" +
                "FROM vehiculo as veh\n" +
                "inner join color as co ON veh.id = co.id_vehiculo \n" +
                "inner join marca as marc ON veh.id=marc.id_vehiculo\n" +
                "where veh.placa= ?\n";

        try{
            Connection connection=ConnexionBD.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,plate);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Car car=new Car();
                car.setId(resultSet.getInt("id"));
                car.setRegistrationNumber(resultSet.getString("matricula"));
                car.setColor(resultSet.getString("tono"));
                car.setBrand(resultSet.getString("nombre"));
                listCar.add(car);
            }
        }catch(SQLException e){
            throw new RuntimeException("ERROR AL CONSULTAR" +e);
        }
        return  listCar;
    }

    @Override
    public void updateCars(Car car) {

    }
}

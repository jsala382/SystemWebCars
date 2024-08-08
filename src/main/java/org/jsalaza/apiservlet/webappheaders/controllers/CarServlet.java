package org.jsalaza.apiservlet.webappheaders.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jsalaza.apiservlet.webappheaders.modelo.Car;
import org.jsalaza.apiservlet.webappheaders.modelo.Color;
import org.jsalaza.apiservlet.webappheaders.modelo.Marca;
import org.jsalaza.apiservlet.webappheaders.services.impl.CarImp;
import org.jsalaza.apiservlet.webappheaders.services.impl.ColorImp;
import org.jsalaza.apiservlet.webappheaders.services.impl.MarcaImp;

import java.io.IOException;
import java.sql.Connection;
import java.util.Arrays;

@WebServlet("/vehiculos,jsp")
public class CarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] branLista = req.getParameterValues("marca");
        String plate = req.getParameter("placa");
        String registrationNumber = req.getParameter("noMatricula");
        String[] color = req.getParameterValues("color");
        //Caso 1 : Para este proceso necesito registrar un vehiculo en primer lugar
        Car car = new Car();
        ColorImp colorImp=new ColorImp();
        MarcaImp marcaImp = new MarcaImp();
        car.setPlate(plate);
        car.setRegistrationNumber(registrationNumber);
        CarImp carImpl = new CarImp();

        carImpl.saveCar(car);
        //Caso 2 Guardar colores basado en los vehiculos regisrtados
        //Caso2.1 sacar el maximo identificado de  la tabla vehiculo
        int idCar=carImpl.maxIndexHeader();
        Arrays.asList(color).forEach(col -> {
            Color color1=new Color();
            color1.setTone(col);
            color1.setIdCar(idCar);
            colorImp.saveColor(color1);
        });
        Arrays.asList(branLista).forEach(mar -> {
           Marca marca=new Marca();
            marca.setNombre(mar);
            marca.setId_vehiculo(idCar);
            marcaImp.saveMarca(marca);
        });


    }
}

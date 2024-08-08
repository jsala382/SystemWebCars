package org.jsalaza.apiservlet.webappheaders.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jsalaza.apiservlet.webappheaders.modelo.Car;
import org.jsalaza.apiservlet.webappheaders.services.impl.CarImp;
import org.jsalaza.apiservlet.webappheaders.services.impl.CarInterface;
import java.util.List;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/buscar-por-placa")
public class CarSearchSevlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Connection conn=(Connection) req.getAttribute("conn");
        String getPlate=req.getParameter("buscarPlaca");
        CarInterface carImpl=new CarImp();

       List<Car> car= carImpl.getCarByPlate("UBA1002");
       req.setAttribute("car",car);
       getServletContext().getRequestDispatcher("/vehiculo.jsp").forward(req,resp);

    }
}

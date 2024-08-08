package org.jsalaza.apiservlet.webappheaders.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jsalaza.apiservlet.webappheaders.modelo.City;
import org.jsalaza.apiservlet.webappheaders.modelo.Client;
import org.jsalaza.apiservlet.webappheaders.modelo.Provinces;
import org.jsalaza.apiservlet.webappheaders.services.impl.CiudadImp;
import org.jsalaza.apiservlet.webappheaders.services.impl.ClientImp;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/crear-clientes")
public class ClientServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClientImp clientImp=new ClientImp();

        String identificationCard=req.getParameter("cedula");
        String name=req.getParameter("nombres");
        String gender=req.getParameter("genero");
        String[] civilStatus=req.getParameterValues("estado_civil");
        String[] typeDocuments=req.getParameterValues("tipo_documentos");
        String address=req.getParameter("direccion");
        String phones=req.getParameter("telefono");
        String provinces=req.getParameter("provincia");
        String city=req.getParameter("ciudad");
        Client client=new Client();
        CiudadImp c=new CiudadImp();
        ClientImp cl=new ClientImp();

        //Establecer cada uno de los atributos de la clase Cliente
        client.setIdentificationCard(identificationCard);
        client.setName(name);
        client.setGender(gender);
        Arrays.asList(civilStatus).forEach(civil->{
            client.setCivilStatus(civil);
        });
        Arrays.asList(typeDocuments).forEach(type->{
            client.setTypeDocuments(type);

        });
        client.setAddress(address);
        client.setPhones(phones);

        int idOne=cl.getIndexClient();
        int idTwo=c.getIndexCity();

        Arrays.asList(provinces).forEach(prov->{
            client.setIdProvinces(3);

        });
        Arrays.asList(city).forEach(cit->{
            City city1=new City();
            city1.setNameCity(cit);

        });
        clientImp.saveClient(client);

    }

}

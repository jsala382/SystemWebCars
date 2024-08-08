package org.jsalaza.apiservlet.webappheaders.services.impl;

import org.jsalaza.apiservlet.webappheaders.modelo.Car;

import java.util.List;

public interface CarInterface {
    void saveCar(Car car);
    List<Car> getCarByColor(String color);
    void deleteCarById(String id);
    List<Car> getCarByPlate(String plate);
    void updateCars(Car car);


}

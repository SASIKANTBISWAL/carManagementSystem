package com.fincity.carManagementSystem.dao;

import java.util.List;

import com.fincity.carManagementSystem.model.Car;

public interface CarsDAO {
	boolean insertCar(Car car);
    boolean updateCar(Car car);
    boolean deleteCar(int id);
    List<Car> findAll();
    Car findById(int id);
    List<Car> findByName(String name);
    List<Car> findByManufacturerName(String manufacturerName);
    List<Car> findByModel(String model);
    List<Car> findByManufacturingYear(String manufacturingYear);
    List<Car> findByColor(String color);
}

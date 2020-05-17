package com.jkxy.car.api.service;

import com.jkxy.car.api.pojo.Car;
import jdk.nashorn.internal.ir.CatchNode;

import java.util.List;


public interface CarService {

    List<Car> findAll();

    Car findById(int id);

    Car findByCarName(String carName);

    void deleteById(int id);

    void updateById(Car car);

    void insertCar(Car car);

    String buyCar(String carName);

    List<Car> findByCarNameAndAmount(String carName,int startNumber, int totalNumber);
}

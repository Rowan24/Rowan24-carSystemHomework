package com.jkxy.car.api.service.Impl;

import com.jkxy.car.api.dao.CarDao;
import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.service.CarService;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("carService")
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public Car findById(int id) {
        return carDao.findById(id);
    }

    @Override
    public Car findByCarName(String carName) {
        return carDao.findByCarName(carName);
    }

    @Override
    public List<Car> findByCarNameAndAmount(String carName, int startNumber, int totalNumber) {
        /*方式一*/
        return carDao.findByCarNameAndAmount(carName,startNumber,totalNumber);


        /*方式二*/
//        List<Car> cars = carDao.findByCarNameAndAmount(carName);
//        List<Car> resultCars = cars.subList(startNumber,totalNumber);
//        System.out.println(resultCars);
//        return resultCars;
    }


    @Override
    public void deleteById(int id) {
        carDao.deleteById(id);
    }

    @Override
    public void updateById(Car car) {
        carDao.updateById(car);
    }

    @Override
    public void insertCar(Car car) {
        carDao.insertCar(car);
    }

    @Override
    public String buyCar(String carName) {
        String result = "没有该车型";
        Car searchCar = carDao.findByCarName(carName);
//        Car searchCar = searchCars.get(0);
        if (searchCar==null){
            return result;
        }
        else{
            int id = searchCar.id;
            String carType = searchCar.carType;
            String price = searchCar.price;
            String carSeries = searchCar.carSeries;
            int carNumber = searchCar.amount;
            if(carNumber>=1){
                carNumber = carNumber - 1;
                Car putCar =new Car(id, carName, carType, price, carSeries, carNumber);
                carDao.updateById(putCar);
                result = "购买成功";
            }else{
                result = "库存不足,购买失败";
            }
        }
        return result;
    }
}

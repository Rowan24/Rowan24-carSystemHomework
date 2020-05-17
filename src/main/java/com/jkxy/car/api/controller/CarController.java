package com.jkxy.car.api.controller;

import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.service.CarService;
import com.jkxy.car.api.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("car")
public class CarController {
    @Autowired
    private CarService carService;

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping("findAll")
    public JSONResult findAll() {
        List<Car> cars = carService.findAll();
        return JSONResult.ok(cars);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @GetMapping("findById/{id}")
    public JSONResult findById(@PathVariable int id) {
        Car car = carService.findById(id);
        return JSONResult.ok(car);
    }

    /**
     * 通过车名查询
     *
     * @param carName
     * @return
     */
    @GetMapping("findByCarName/{carName}")
    public JSONResult findByCarName(@PathVariable String carName) {
        Car cars = carService.findByCarName(carName);
        return JSONResult.ok(cars);
    }


    /**
     * 通过carName查询指定开头和数目的车辆
     *
     * @return
     */
//    @GetMapping("findByCarNameAndAmount/{carName}/{startNumber}/{totalNumber}")
//    public JSONResult findByCarNameAndAmount(@PathVariable String carName, @PathVariable int startNumber, @PathVariable int totalNumber) {
//        List<Car> cars = carService.findByCarNameAndAmount(carName=carName,startNumber=startNumber,totalNumber=totalNumber);
//        return JSONResult.ok(cars);
//    }

      @GetMapping("findByCarNameAndAmount/{carName}/{startNumber}/{totalNumber}")
      public JSONResult findByCarNameAndAmount(@PathVariable String carName, @PathVariable int startNumber, @PathVariable int totalNumber) {
          List<Car> cars = carService.findByCarNameAndAmount(carName,startNumber,totalNumber);
          return JSONResult.ok(cars);
      }


    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @GetMapping("deleteById/{id}")
    public JSONResult deleteById(@PathVariable int id) {
        carService.deleteById(id);
        return JSONResult.ok();
    }

    /**
     * 通过id更新全部信息
     *
     * @return
     */
    @PostMapping("updateById")
    public JSONResult updateById(Car car) {
        carService.updateById(car);
        return JSONResult.ok();
    }
    /**
     * 通过carName购买车辆
     *
     * @return
     */
    @PostMapping("buyCar/{carName}")
    public JSONResult buyCar(@PathVariable String carName) {
        String result = carService.buyCar(carName);
        return JSONResult.ok(result);
    }


    /**
     * 通过id增加
     *
     * @param car
     * @return
     */
    @PostMapping("insertCar")
    public JSONResult insertCar(Car car) {
        carService.insertCar(car);
        return JSONResult.ok();
    }
}

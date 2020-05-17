package com.jkxy.car.api.dao;

import com.jkxy.car.api.pojo.Car;
import org.apache.ibatis.annotations.*;
import org.omg.CORBA.INTERNAL;
import sun.awt.image.IntegerInterleavedRaster;

import java.util.List;


@Mapper
public interface CarDao {
    @Select("select * from carMessage")
    List<Car> findAll();

    @Select("select * from carMessage where id = #{id}")
    Car findById(int id);

    @Select("select * from carMessage where carName = #{carName}")
    Car findByCarName(String carName);

    @Select("select * from carSys.carMessage where carName = #{carName} limit #{startNumber},#{totalNumber}")
    List<Car> findByCarNameAndAmount(String carName, int startNumber, int totalNumber);
//    @Select("SELECT * from carMessage where carName='凯迪拉克' limit #{startNumber},#{totalNumber}")
//    List<Car> findByCarNameAndAmount(String carName, int startNumber, int totalNumber);
//    @Select("SELECT * from carMessage where carName=#{carName}")
//    List<Car> findByCarNameAndAmount(String carName);

    @Delete("delete from carMessage where id = #{id}")
    void deleteById(int id);

    @Update("update carMessage set carName=#{carName},carType=#{carType},price=#{price},carSeries=#{carSeries},amount=#{amount} where id = #{id}")
    void updateById(Car car);

    @Insert("insert into carMessage(carName,carType,price,carSeries,amount) values(#{carName},#{carType},#{price},#{carSeries},#{amount})")
    void insertCar(Car car);

}

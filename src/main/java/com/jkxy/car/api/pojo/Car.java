package com.jkxy.car.api.pojo;


public class Car {
    public int id;
    public String carName;
    public String carType;
    public String price;
    public String carSeries;
    public int amount;

    public Car() {
    }

    public Car(int id, String carName, String carType, String price, String carSeries, int amount) {
        this.id = id;
        this.carName = carName;
        this.carType = carType;
        this.price = price;
        this.carSeries = carSeries;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCarSeries() {
        return carSeries;
    }

    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", carType='" + carType + '\'' +
                ", price='" + price + '\'' +
                ", carSeries='" + carSeries + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}

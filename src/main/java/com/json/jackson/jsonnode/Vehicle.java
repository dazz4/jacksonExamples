package com.json.jackson.jsonnode;

import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    private Car car;
    private int wheels;

    public Vehicle() {
    }

    public Vehicle(Car car, int wheels) {
        this.car = car;
        this.wheels = wheels;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }
}

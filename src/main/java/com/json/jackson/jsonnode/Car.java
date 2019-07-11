package com.json.jackson.jsonnode;

import org.springframework.stereotype.Component;

@Component
public class Car extends Vehicle {

    private String model;
    private int gears;

    public Car() {
    }

    public Car(String model, int gears) {
        this.model = model;
        this.gears = gears;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", gears=" + gears +
                '}';
    }
}

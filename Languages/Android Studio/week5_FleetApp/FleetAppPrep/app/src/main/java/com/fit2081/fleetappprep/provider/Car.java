package com.fit2081.fleetappprep.provider;

public class Car {
    String maker;
    String model;

    public Car(String maker, String model) {
        this.maker = maker;
        this.model = model;
    }

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }
}
